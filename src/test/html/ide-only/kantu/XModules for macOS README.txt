***************************************************
UI.Vision XModules License 

This installation includes:
(1) FileAccess XModule for macOS, V1.0.12
(2) RealUser Simulation XModule for macOS, V1.0.12
(3) ComputerVision XModule for macOS, V1.0.19

For more information see https://ui.vision/x
***************************************************

Thank you for using the UI.Vision XModules.

To install:

1. Copy the content of this ZIP file to a folder of your choice

TIPS:

(A) Do NOT move the XModules folder after the installation. The reason is that the installation script tells Chrome and/or Firefox where to find the the XModules. The files itself are not copied to a new location. So if you would move the folder, Kantu would report the XModules as uninstalled, as it can not find them any longer. If you want to move the location of the folder later, it is best if you first run the uninstall scripts in the old location and then run the 1install.sh installation script again in the new location.

(B) Please make sure that the extracted files are executable. If they are not, you need to make them executable with "chmod +x" before running the 1install.sh script.

2. Run the included shell scripts "1install.sh"

You do this by opening the terminal, navigate to the folder to which you copied the file and type

bash 1install.sh

(Note that it is "bash", not "sh").

You should then see several messages that say "Native messaging host... installed"

The installation is done now!

3. (Optional) As the last step you can customize the UI.Vision RPA home folder location. By default, Kantu uses "<your Desktop folder>/uivision" as the home directory. If you want to change this, open the 
UI.Vision RPA browser extension, open "Settings", go to the "XModule" tab and enter a new home folder - macros, testsuites and CSV files will be stored in subfolders below this folder. 

For more information please visit the XModules home page at

https://ui.vision/rpa/x

If you have any questions or suggestions, 
please post them in the UI.Vision user forum at

https://forum.ui.vision/ 

Happy Automation!

The UI.Vision Team


