package com.zhou;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @Author: zhouweixin
 * @Description: 为TreeView添加选择的事件
 * @Date: Created in 下午2:38:51 2018年6月4日
 */
public class Demo4 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 【1】创建树
		TreeView<String> treeView = new TreeView<String>();
		treeView.setVisible(true);
		// 【2】创建根
		CheckBoxTreeItem<String> rootItem = new CheckBoxTreeItem<String>("根");
		rootItem.setExpanded(true);
		treeView.setRoot(rootItem);
		// 【3】创建节点
		for (int i = 1; i <= 5; i++) {
			CheckBoxTreeItem<String> nodeItem = new CheckBoxTreeItem<String>("节点" + i);
			rootItem.getChildren().add(nodeItem);

			// 【6】添加事件
			// nodeItem.selectedProperty().addListener((observable, oldValue, newValue) -> {
			// if(newValue == true) {
			// System.out.println(nodeItem + "--被勾选");
			// } else {
			// System.out.println(nodeItem + "--取消勾选");
			// }
			// });

			// 【7】添加事件， 会连带父节点
			// nodeItem.addEventHandler(CheckBoxTreeItem.checkBoxSelectionChangedEvent(),
			// (event) -> {
			// CheckBoxTreeItem<Object> treeItem = event.getTreeItem();
			//
			// if (treeItem.isSelected()) {
			// System.out.println(treeItem + "被勾选");
			// } else {
			// System.out.println(treeItem + "未被勾选");
			// }
			// });		
		}
		
		// 【8】选择节点，而不是勾选
		treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
			System.out.println(observable.getValue() + "--被选择");
		});

		// 【4】显示复选框
		treeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

		// 【5】可设置节点独立--选择父节点，子节点不会受到影响
		rootItem.setIndependent(true);

		// 创建边界布局
		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(treeView);

		// 创建场景
		Scene scene = new Scene(borderPane, 400, 400);
		primaryStage.setScene(scene);
		// 显示
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
