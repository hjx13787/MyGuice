package com.test.composite;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TemperatureConverterJFace extends ApplicationWindow {
    Label fahrenheitLabel;
    Label celsiusLabel;
    Text fahrenheitValue;
    Text celsiusValue;

    public TemperatureConverterJFace() {

	super(null);

	addStatusLine();
    }

    protected Control createContents(Composite parent) {
	getShell().setText("JFace Temperature Converter");

	Composite converterComposite = new Composite(parent, SWT.NULL);

	converterComposite.setLayout(new GridLayout(4, false));
	fahrenheitLabel = new Label(converterComposite, SWT.NULL);
	fahrenheitLabel.setText("Fahrenheit: ");
	fahrenheitValue = new Text(converterComposite, SWT.SINGLE | SWT.BORDER);
	celsiusLabel = new Label(converterComposite, SWT.NULL);
	celsiusLabel.setText("Celsius: ");
	celsiusValue = new Text(converterComposite, SWT.SINGLE | SWT.BORDER);
	ModifyListener listener = new ModifyListener() {
	    public void modifyText(ModifyEvent e) {
		valueChanged((Text) e.widget);
	    }
	};
	fahrenheitValue.addModifyListener(listener);
	celsiusValue.addModifyListener(listener);

	return converterComposite;
    }

    public void valueChanged(Text text) {
	if (!text.isFocusControl())
	    return;
	if (text == fahrenheitValue) {
	    try {
		double fValue = Double.parseDouble(text.getText());
		double cValue = (fValue - 32) / 1.8;
		celsiusValue.setText(Double.toString(cValue));
		System.out.println("F -> C: " + cValue);
		setStatus("Conversion performed successfully.");
	    } catch (NumberFormatException e) {
		celsiusValue.setText("");
		setStatus("Invalid number format: " + text.getText());
	    }
	} else {
	    try {
		double cValue = Double.parseDouble(text.getText());
		double fValue = cValue * 1.8 + 32;
		fahrenheitValue.setText(Double.toString(fValue));
		System.out.println("C -> F: " + fValue);
		setStatus("Conversion performed successfully.");
	    } catch (NumberFormatException e) {
		fahrenheitValue.setText("");
		setStatus("Invalid number format: " + text.getText());
	    }
	}
    }

    public static void main(String[] args) {
	TemperatureConverterJFace converter = new TemperatureConverterJFace();
	converter.setBlockOnOpen(true);
	converter.open();
	Display.getCurrent().dispose();
    }
}