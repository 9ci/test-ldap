/*
grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
*/
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

grails {
	project {
		dependency.resolver = 'maven'
		dependency.resolution = {
			// inherit Grails' default dependencies
			inherits("global") {}
			log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

			repositories {
				grailsPlugins()
				grailsHome()
				grailsCentral()
				mavenLocal()
				mavenCentral()
				mavenRepo "http://repo.spring.io/milestone/"
			}

			dependencies {
			}

			plugins {
				build ':tomcat:7.0.42'
				runtime ':hibernate:3.6.10.18'
				compile ":cache:1.1.8"
//				runtime ":jquery:1.8.3"
				compile ":asset-pipeline:2.1.1"

				// Uncomment these (or add new ones) to enable additional resources capabilities
				//runtime ":zipped-resources:1.0"
				//runtime ":cached-resources:1.0"
				//runtime ":yui-minify-resources:0.1.5"


				runtime ":database-migration:1.3.2"
				compile ":spring-security-core:2.0-RC4"
				compile ":spring-security-ldap:2.0-RC2"

			}
		}
		work.dir = '.grails'
	}
}

