package com.test.myguice;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloSWT {

    public static void main(String[] args) {

	// 创建一个display对象。

	Display display = new Display();

	// shell是程序的主窗体

	Shell shell = new Shell(display);

	// 设置shell的布局方式

	shell.setLayout( null );

	// 声明一个可以显示多行信息的文本框

	Text hello = new Text(shell, SWT. MULTI );

	// 设置主窗体的标题

	shell.setText( "Java应用程序" );

	// 设置主窗体的大小

	shell.setSize(325, 276);

	// 声明颜色对象

	Color color = new Color(Display.getCurrent(), 255, 255, 255);

	// 设置窗体的背景颜色

	shell.setBackground(color);

	// 设置文本框信息

	hello.setText( "Hello, SWT World!\n\n你好，SWT世界！" );

	// 打开主窗体

	shell.open();

	// 如果主窗体没有关闭则一直循环

	while (!shell.isDisposed()) {

	    // 如果display不忙

	    if (!display.readAndDispatch()) {

		display.sleep();

		// 休眠

	    }

	}

	display.dispose();

	// 销毁display

    }
}
