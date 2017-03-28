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

cp ~/config.json ~/mattermost/config/config.json

cd ~/mattermost
./bin/platform reset --confirm true

./bin/platform user create --email admin@test.com --username admin --password passwd
./bin/platform user create --email test@test.com --username test --password passwd
./bin/platform user create --email test2@test.com --username test2 --password passwd
./bin/platform user create --email test3@test.com --username test3 --password passwd
./bin/platform user create --email test4@test.com --username test4 --password passwd
./bin/platform user create --email test5@test.com --username test5 --password passwd
./bin/platform user create --email test6@test.com --username test6 --password passwd
./bin/platform user create --email test7@test.com --username test7 --password passwd
./bin/platform user create --email test8@test.com --username test8 --password passwd
./bin/platform user create --email test9@test.com --username test9 --password passwd
./bin/platform user create --email test10@test.com --username test10 --password passwd

./bin/platform team create --name ui-automation --display_name "UI Automation" --email "test2@test.com"
./bin/platform team add ui-automation admin@test.com test@test.com test2@test.com test3@test.com test4@test.com test5@test.com test6@test.com test7@test.com test8@test.com test9@test.com test10@test.com

mysql -u mmuser -ppasswd -h localhost -e "UPDATE Preferences SET Value = '999' WHERE Category = 'tutorial_step';" mattermost


sudo systemctl start mattermost