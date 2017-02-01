#!/bin/bash

sudo systemctl stop mattermost

tar czPf ~/logs/archive-pre-$0.tar.gz ~/mattermost/logs
cp ~/mattermost/logs/mattermost.log $1/mm-latest.log

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

cp ~/config.json ~/mattermost/config/config.json

cd ~/mattermost
./bin/platform reset --confirm true

./bin/platform user create --email test@test.com --username test --password passwd
./bin/platform user create --email test2@test.com --username test2 --password passwd
./bin/platform user create --email test3@test.com --username test3 --password passwd
./bin/platform user create --email test4@test.com --username test4 --password passwd

./bin/platform team create --name ui-automation --display_name "UI Automation" --email "test2@test.com"
./bin/platform team add ui-automation test@test.com test2@test.com test3@test.com test4@test.com

sudo systemctl start mattermost