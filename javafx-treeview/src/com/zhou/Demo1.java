package com.zhou;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @Author: zhouweixin
 * @Description: 简单TreeView的创建
 * @Date: Created in 下午2:38:51 2018年6月4日
 */
public class Demo1 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 【1】创建树
		TreeView<String> treeView = new TreeView<String>();
		treeView.setVisible(true);
		// 【2】创建根
		TreeItem<String> rootItem = new TreeItem<String>("根");
		rootItem.setExpanded(true);
		treeView.setRoot(rootItem);
		// 【3】创建节点
		for(int i=1; i<=5; i++) {
			TreeItem<String> nodeItem = new TreeItem<String>("节点"+i);
			rootItem.getChildren().add(nodeItem);
		}
		
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
