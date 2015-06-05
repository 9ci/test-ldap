/**
 * Created by Juan Vazquez.
 * Modified by Ken Roberts at 9ci Inc
 * URL: http://www.9ci.com
 * Code is provide for educational purposes. Any use in a production system is at your own risk.
 */

grails.config.locations = [
    "classpath:9ci-config.groovy",
    "classpath:testLdap-config.groovy"
    ]

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}


//Active directory setup, read the spring-security-ldap docs for more information
grails.plugins.springsecurity.providerNames = ['ldapAuthProvider']
grails.plugins.springsecurity.ldap.context.managerDn = 'lgk@nine.local'
grails.plugins.springsecurity.ldap.context.managerPassword = '611Nrt83'
grails.plugins.springsecurity.ldap.context.server = 'ldap://dc1vm2k8:389'
//grails.plugins.springsecurity.ldap.authorities.groupSearchBase = 'ou=Accounts,dc=yourdomain,dc=com'
grails.plugins.springsecurity.ldap.authorities.retrieveGroupRoles = false
grails.plugins.springsecurity.ldap.authorities.retrieveDatabaseRoles = true
grails.plugins.springsecurity.ldap.mapper.userDetailsClass = 'Person'
grails.plugins.springsecurity.ldap.search.filter='(&(objectClass=user)(sAMAccountName={0})(memberOf=CN=9ci-app-users,DC=nine,DC=local))'
grails.plugins.springsecurity.ldap.search.base = 'CN=users,DC=nine,DC=local'
