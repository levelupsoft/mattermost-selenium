#!/bin/bash

sudo systemctl stop mattermost

tar czPf ~/logs/archive-pre-$BUILD_ID.tar.gz ~/mattermost/logs
cp ~/mattermost/logs/mattermost.log $WORKSPACE/mm-latest.log

rm -f mattermost.tar.gz

# # Regular daily
wget https://releases.mattermost.com/mattermost-platform/master/mattermost-enterprise-linux-amd64.tar.gz
mv mattermost-enterprise-linux-amd64.tar.gz mattermost.tar.gz

# Use this to lock to specific version
#wget http://releases.mattermost.com/3.6.1/mattermost-enterprise-3.6.1-linux-amd64.tar.gz
#mv mattermost-enterprise-3.6.1-linux-amd64.tar.gz mattermost.tar.gz

rm -rf ~/mattermost

mkdir -p ~/mattermost

tar -C ~/ -xzf mattermost.tar.gz

mv ~/config.json ~/mattermost/config/config.json

sudo systemctl start mattermost