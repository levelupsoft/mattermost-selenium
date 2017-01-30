.PHONY: test test-chrome test-all clean

all: test-all

clean:
	mvn clean

nuke:
	mvn clean
	rm -rf src/test/resources/selenium_standalone_binaries
	rm -rf src/test/resources/selenium_standalone_zips

test:
	mvn clean verify

test-chrome:
	mvn -Dbrowser=chrome clean verify

test-firefox:
	mvn -Dbrowser=firefox clean verify

test-all: 
	mvn -Dbrowser=firefox clean verify
	mvn -Dbrowser=chrome clean verify