# VS Code Debugger Configuration for Java Project

This directory contains the configuration files for debugging Java tests in VS Code.

## How to Use the Debugger

### Prerequisites
1. Make sure you have the following VS Code extensions installed:
   - Extension Pack for Java (by Microsoft)
   - Test Runner for Java (by Microsoft)

### Debugging Options

1. **Debug Current Test File**
   - Open any Java test file
   - Press F5 or go to Run > Start Debugging
   - Select "Debug Current Test File" from the dropdown
   - This will run the current file as a TestNG test using Maven

2. **Debug SQLTests specifically**
   - Open the Debug view (Ctrl+Shift+D)
   - Select "Debug SQLTests" from the dropdown
   - Press F5 to start debugging
   - This will run the SQLTests class using Maven with debug options

3. **Debug TestNG Tests**
   - Open the Debug view (Ctrl+Shift+D)
   - Select "Debug TestNG Tests" from the dropdown
   - Press F5 to start debugging
   - This will run the SQLTests class using Maven with debug options

4. **Debug Maven Test**
   - Open the Debug view (Ctrl+Shift+D)
   - Select "Debug Maven Test" from the dropdown
   - Press F5 to start debugging
   - This will run Maven tests with the SQLTests class

5. **Debug with Maven Surefire (Recommended)**
   - Open the Debug view (Ctrl+Shift+D)
   - Select "Debug with Maven Surefire" from the dropdown
   - Press F5 to start debugging
   - This uses Maven's Surefire plugin with debug options enabled

6. **Debug SQLTests (Maven Exec)**
   - Open the Debug view (Ctrl+Shift+D)
   - Select "Debug SQLTests (Maven Exec)" from the dropdown
   - Press F5 to start debugging
   - This uses Maven Exec plugin to run TestNG with proper classpath

### Important Notes
- All debug configurations now use shell commands to execute Maven
- This ensures proper classpath resolution for all dependencies including TestNG
- The debugger will wait for you to attach to the process when using debug configurations

### Setting Breakpoints
- Click in the gutter to the left of the line number where you want to set a breakpoint
- A red dot will appear indicating the breakpoint is set
- The debugger will pause execution at these points

### Debugging Controls
- F5: Continue/Start Debugging
- F10: Step Over
- F11: Step Into
- Shift+F11: Step Out
- Ctrl+Shift+F5: Restart Debugging
- Shift+F5: Stop Debugging

### Viewing Variables
- Use the VARIABLES panel in the Debug view to inspect variable values
- You can also hover over variables in the code to see their current values

### Watch Expressions
- Add expressions to the WATCH panel to monitor specific values
- Right-click in the WATCH panel and select "Add Expression"

### Debug Console
- Use the DEBUG CONSOLE to execute expressions and view debug output
- You can evaluate expressions and modify variable values during debugging

## Notes
- The configuration is set up to automatically compile the project before debugging
- MySQL connection is required for the SQLTests (localhost:3306/db with user 'root' and password '11111111')
- ChromeDriver is required for the Selenium tests in SQLTests