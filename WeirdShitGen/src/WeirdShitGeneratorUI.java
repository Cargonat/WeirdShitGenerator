
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WeirdShitGeneratorUI
{
    private JFrame _frame;
    private JButton _generateButton;
    private JButton _saveButton;
    private JLabel _label;
    private JLabel _credits;
    private JPanel _buttonPanel;

    private JPanel _rerollPanel;
    private JButton _typeButton;
    private JButton _originButton;
    private JButton _compButton;
    private JButton _growButton;
    private JButton _prop1Button;
    private JButton _prop2Button;
    private JButton _verb1Button;
    private JButton _verb2Button;

    private String _text = "<html><body>This [type] comes from [origin] and is made of [composition]. "
            + "It reproduces or grows via [reproductionOrGrowth]. It [specialProperty1] and [specialProperty2]. "
            + "It [verb1] and it [verb2].</body></html>";

    public WeirdShitGeneratorUI()
    {
        _frame = new JFrame();
        _frame.setTitle("Weird Shit Generator Fantasy");
        _frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        _frame.getContentPane()
            .setLayout(new BorderLayout());
        _frame.setLocationRelativeTo(null);

        _generateButton = new JButton("Generate Some Weird Shit");
        _saveButton = new JButton("Save");
        _typeButton = new JButton("Type");
        _originButton = new JButton("Origin");
        _compButton = new JButton("Composition");
        _growButton = new JButton("Repr./Growth");
        _prop1Button = new JButton("Property 1");
        _prop2Button = new JButton("Property 2");
        _verb1Button = new JButton("Verb 1");
        _verb2Button = new JButton("Verb 2");

        _buttonPanel = new JPanel(new GridLayout(2, 1));
        _rerollPanel = new JPanel(new GridLayout(2, 4));

        _rerollPanel.add(_typeButton);
        _rerollPanel.add(_originButton);
        _rerollPanel.add(_compButton);
        _rerollPanel.add(_growButton);
        _rerollPanel.add(_prop1Button);
        _rerollPanel.add(_prop2Button);
        _rerollPanel.add(_verb1Button);
        _rerollPanel.add(_verb2Button);

        _buttonPanel.add(_generateButton);
        _buttonPanel.add(_rerollPanel);

        _label = new JLabel(_text);

        _credits = new JLabel(
                "Credit for the original random tables goes to Trevor Scott from the Never Engine Blog.",
                SwingConstants.RIGHT);

        _frame.add(_buttonPanel, BorderLayout.NORTH);
        _frame.add(_label, BorderLayout.CENTER);
        _frame.add(_credits, BorderLayout.SOUTH);
        _frame.add(_saveButton, BorderLayout.EAST);
    }

    public JButton getSaveButton()
    {
        return _saveButton;
    }

    public JButton getGenerateButton()
    {
        return _generateButton;
    }

    public JButton getTypeButton()
    {
        return _typeButton;
    }

    public JButton getOriginButton()
    {
        return _originButton;
    }

    public JButton getCompButton()
    {
        return _compButton;
    }

    public JButton getGrowButton()
    {
        return _growButton;
    }

    public JButton getProp1Button()
    {
        return _prop1Button;
    }

    public JButton getProp2Button()
    {
        return _prop2Button;
    }

    public JButton getVerb1Button()
    {
        return _verb1Button;
    }

    public JButton getVerb2Button()
    {
        return _verb2Button;
    }

    public void setText(String text)
    {
        _text = text;
        _label.setText(text);
    }

    public void zeigeFenster()
    {
        _frame.setSize(500, 300);
        _frame.setVisible(true);
    }
}
