# TextEditor

This is a simple text editor application built using Java Swing. It provides basic functionalities such as creating, opening, editing, and saving text files. It also allows users to customize the font type, size, and color of the text.

## Features

- Open and save text files.
- Change the font type.
- Adjust the font size.
- Change the text color.
- Simple and intuitive GUI.

## Requirements

- Java Development Kit (JDK) 8 or higher.

## Installation

1. Ensure you have JDK 8 or higher installed on your system. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Clone or download the repository to your local machine.

## Usage

1. Open your terminal or command prompt.
2. Navigate to the directory where the `TextEditor.java` file is located.
3. Compile the `TextEditor.java` file using the following command:

    ```sh
    javac TextEditor.java
    ```

4. Run the compiled class file using the following command:

    ```sh
    java texteditor.TextEditor
    ```

## File Structure

The project contains a single Java file:

- `TextEditor.java`: The main file containing the implementation of the text editor.

## Code Explanation

The `TextEditor` class extends `JFrame` and implements `ActionListener` to handle various user actions. Below is a brief overview of its components:

- `JTextArea textArea`: The main text area where users can type and edit text.
- `JScrollPane scrollPane`: A scroll pane to make the text area scrollable.
- `JSpinner FontSizeSpinner`: A spinner to adjust the font size.
- `JLabel fontLabel`: A label for the font size spinner.
- `JButton fontButton`: A button to change the text color.
- `JComboBox fontBox`: A combo box to select the font type.
- `JMenuBar menuBar`: The menu bar containing file operations.
- `JMenu menu`: The file menu containing menu items for file operations.
- `JMenuItem openItem`, `saveItem`, `exitItem`: Menu items for opening, saving, and exiting the application.

### Event Handling

The `actionPerformed` method handles the following actions:

- Change text color when `fontButton` is clicked.
- Change font type when an item from `fontBox` is selected.
- Open a file and display its content in `textArea` when `openItem` is clicked.
- Save the content of `textArea` to a file when `saveItem` is clicked.
- Exit the application when `exitItem` is clicked.

## Contributing

If you wish to contribute to the project, feel free to fork the repository and submit a pull request.

## License

This project is open-source and available under the MIT License.

## Contact

For any questions or suggestions, please open an issue in the repository.

---

This `README.md` file provides all necessary information to understand, set up, and use the TextEditor application. Make sure to follow the instructions carefully to get the application up and running.
