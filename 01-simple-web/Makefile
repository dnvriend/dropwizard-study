.PHONY: help
.DEFAULT_GOAL := help

help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

build: ## build the app
	mvn clean install

run: ## run the app
	java -jar target/simple-web-1.0-SNAPSHOT.jar server config.yml

open: ## open the browser
	open http://localhost:8080

health: ## health check
	open http://localhost:8081/healthcheck