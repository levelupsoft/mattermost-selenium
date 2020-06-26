#!/bin/sh
# Install all UI.Vision XModules - https://ui.vision/rpa/x  

all_host_x="1"

file="kantu-xy-host"
if [[ ! -x "$file" ]]; then
    echo "File '$file' is not executable or found"
    all_host_x="0"
fi

file="kantu-cv-host"
if [[ ! -x "$file" ]]; then
    echo "File '$file' is not executable or found"
    all_host_x="0"
fi

file="kantu-file-access-host"
if [[ ! -x "$file" ]]; then
    echo "File '$file' is not executable or found"
    all_host_x="0"
fi

if [ "$all_host_x" -eq "0" ]; then 
    echo "It seems the extracted files are NOT executable. You need to make them executable with chmod +x."

else

echo "Installing FileAccess XModule..."
bash fileaccess_install_chrome.sh
bash fileaccess_install_firefox.sh
echo "FileAccess XModule installed."

echo "Installing RealUser Simulation XModule..."
bash realuser_install_chrome.sh
bash realuser_install_firefox.sh
echo "RealUser Simulation XModule installed."

echo "Installing ComputerVision XModule..."
bash cv_install_chrome.sh
bash cv_install_firefox.sh
echo "ComputerVision XModule installed."
echo
echo "All done. Happy Automation!"
echo
echo "Tip: Please do NOT move or delete the XModules folder after the installation. The installation script has only told Chrome and Firefox where to find the XModules. The files itself have not been copied to a new location."

fi





