package org.fundaciobit.powertoys.logic.earmoduls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que representa els mòduls d'un JBoss 7.4.0
 * @author anadal
 * 13 oct 2025 11:51:26
 */
public class JBoss7_4_0 extends JBoss {

    public static final String VERSION = "7.4.0";

    public JBoss7_4_0() {
        super(moduls_7_4);
    }

    private static final List<Module> moduls_7_4 = new ArrayList<Module>();

    static {
        moduls_7_4.add(new Module("asm.asm",
                new String[] { "asm-7.1.0.redhat-00001.jar", "asm-util-7.1.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("ch.qos.cal10n", new String[] { "cal10n-api-0.8.1.redhat-1.jar" }));
        moduls_7_4.add(new Module("com.fasterxml.classmate", new String[] { "classmate-1.5.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.fasterxml.jackson.core.jackson-annotations",
                new String[] { "jackson-annotations-2.12.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.fasterxml.jackson.core.jackson-core",
                new String[] { "jackson-core-2.12.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.fasterxml.jackson.core.jackson-databind",
                new String[] { "jackson-databind-2.12.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.fasterxml.jackson.datatype.jackson-datatype-jdk8",
                new String[] { "jackson-datatype-jdk8-2.12.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.fasterxml.jackson.datatype.jackson-datatype-jsr310",
                new String[] { "jackson-datatype-jsr310-2.12.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.fasterxml.jackson.jaxrs.jackson-jaxrs-json-provider",
                new String[] { "jackson-jaxrs-json-provider-2.12.1.redhat-00001.jar",
                        "jackson-jaxrs-base-2.12.1.redhat-00001.jar",
                        "jackson-module-jaxb-annotations-2.12.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.github.ben-manes.caffeine", new String[] { "caffeine-2.8.8.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.github.fge.btf", new String[] { "btf-1.2.0.redhat-00007.jar" }));
        moduls_7_4.add(new Module("com.github.fge.jackson-coreutils",
                new String[] { "jackson-coreutils-1.8.0.redhat-00002.jar" }));
        moduls_7_4.add(new Module("com.github.fge.json-patch", new String[] { "json-patch-1.9.0.redhat-00002.jar" }));
        moduls_7_4.add(new Module("com.github.fge.msg-simple", new String[] { "msg-simple-1.1.0.redhat-00007.jar" }));
        moduls_7_4.add(new Module("com.github.spullara.mustache", new String[] { "compiler-0.9.6.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.google.code.gson", new String[] { "gson-2.8.6.redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("com.google.guava.failureaccess", new String[] { "failureaccess-1.0.1.redhat-00002.jar" }));
        moduls_7_4.add(new Module("com.google.guava", new String[] { "guava-30.1.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.googlecode.javaewah", new String[] { "JavaEWAH-1.1.7.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.h2database.h2", new String[] { "h2-1.4.197.redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("com.microsoft.azure.storage", new String[] { "azure-storage-8.6.5.redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.squareup.okhttp3",
                new String[] { "okhttp-3.9.0.redhat-3.jar", "okio-1.13.0.redhat-3.jar" }));
        moduls_7_4.add(new Module("com.sun.jsf-impl", new String[] { "jsf-impl-2.3.14.SP04-redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.sun.xml.bind",
                new String[] { "istack-commons-runtime-3.0.10.redhat-00001.jar",
                        "istack-commons-tools-3.0.10.redhat-00001.jar", "rngom-2.3.3.b02-redhat-00001.jar",
                        "relaxng-datatype-2.3.3.b02-redhat-00001.jar", "codemodel-2.3.3.b02-redhat-00001.jar",
                        "jaxb-jxc-2.3.3.b02-redhat-00001.jar", "jaxb-runtime-2.3.3.b02-redhat-00001.jar",
                        "jaxb-xjc-2.3.3.b02-redhat-00001.jar", "xsom-2.3.3.b02-redhat-00001.jar",
                        "txw2-2.3.3.b02-redhat-00001.jar" }));
        moduls_7_4.add(new Module("com.sun.xml.fastinfoset", new String[] { "FastInfoset-1.2.13.redhat-1.jar" }));
        moduls_7_4.add(new Module("com.sun.xml.messaging.saaj", new String[] { "saaj-impl-1.4.1.SP1-redhat-00001.jar",
                "stax-ex-1.8.3.redhat-00002.jar", "saaj-impl-1.3.16.SP1-redhat-6.jar" }));
        moduls_7_4.add(new Module("gnu.getopt", new String[] { "java-getopt-1.0.13.redhat-5.jar" }));
        moduls_7_4.add(new Module("ibm.jdk", new String[] { "" }));
        moduls_7_4.add(new Module("io.agroal", new String[] { "agroal-api-1.3.0.redhat-00001.jar",
                "agroal-narayana-1.3.0.redhat-00001.jar", "agroal-pool-1.3.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("io.netty", new String[] { "netty-all-4.1.59.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("io.reactivex.rxjava2.rxjava", new String[] { "rxjava-2.2.20.redhat-00001.jar" }));
        moduls_7_4.add(new Module("io.reactivex.rxjava3.rxjava", new String[] { "rxjava-3.0.9.redhat-00001.jar" }));
        moduls_7_4.add(new Module("io.undertow.core", new String[] { "undertow-core-2.2.5.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("io.undertow.js", new String[] { "undertow-js-1.0.2.Final-redhat-1.jar" }));
        moduls_7_4.add(new Module("io.undertow.jsp", new String[] { "jastow-2.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("io.undertow.servlet", new String[] { "undertow-servlet-2.2.5.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("io.undertow.websocket",
                new String[] { "undertow-websockets-jsr-2.2.5.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javaee.api", new String[] { "" }));
        moduls_7_4
                .add(new Module("javax.activation.api", new String[] { "jakarta.activation-1.2.2.redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.annotation.api",
                new String[] { "jboss-annotations-api_1.3_spec-2.0.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.api", new String[] { "" }));
        moduls_7_4.add(new Module("javax.batch.api",
                new String[] { "jboss-batch-api_1.0_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("javax.ejb.api", new String[] { "jboss-ejb-api_3.2_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4
                .add(new Module("javax.el.api", new String[] { "jboss-el-api_3.0_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.enterprise.api",
                new String[] { "jakarta.enterprise.cdi-api-2.0.2.redhat-00002.jar" }));
        moduls_7_4.add(new Module("javax.enterprise.concurrent.api",
                new String[] { "jboss-concurrency-api_1.0_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("javax.faces.api", new String[] { "jboss-jsf-api_2.3_spec-3.0.0.SP04-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.inject.api", new String[] { "jakarta.inject-api-1.0.3.redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.interceptor.api",
                new String[] { "jboss-interceptors-api_1.2_spec-2.0.0.Final-redhat-00002.jar" }));
        moduls_7_4.add(
                new Module("javax.jms.api", new String[] { "jboss-jms-api_2.0_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.json.api", new String[] { "jakarta.json-api-1.1.6.redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("javax.json.bind.api", new String[] { "jakarta.json.bind-api-1.0.2.redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.jws.api", new String[] { "jsr181-api-1.0.0.MR1-redhat-8.jar" }));
        moduls_7_4.add(new Module("javax.mail.api", new String[] { "jakarta.mail-1.6.5.redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.management.j2ee.api",
                new String[] { "jboss-j2eemgmt-api_1.1_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.orb.api", new String[] { "openjdk-orb-8.1.4.Final-redhat-00002.jar" }));
        moduls_7_4.add(
                new Module("javax.persistence.api", new String[] { "jakarta.persistence-api-2.2.3.redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.resource.api",
                new String[] { "jboss-connector-api_1.7_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.rmi.api", new String[] { "" }));
        moduls_7_4.add(new Module("javax.security.auth.message.api",
                new String[] { "jboss-jaspi-api_1.1_spec-2.0.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.security.enterprise.api",
                new String[] { "jakarta.security.enterprise-api-1.0.2.redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.security.jacc.api",
                new String[] { "jboss-jacc-api_1.5_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.servlet.api",
                new String[] { "jboss-servlet-api_4.0_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.servlet.jsp.api",
                new String[] { "jboss-jsp-api_2.3_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.servlet.jstl.api",
                new String[] { "taglibs-standard-spec-1.2.6.RC1-redhat-1.jar",
                        "taglibs-standard-impl-1.2.6.RC1-redhat-1.jar",
                        "taglibs-standard-compat-1.2.6.RC1-redhat-1.jar" }));
        moduls_7_4.add(new Module("javax.sql.api", new String[] { "" }));
        moduls_7_4.add(new Module("javax.transaction.api",
                new String[] { "jboss-transaction-api_1.3_spec-2.0.0.Final-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("javax.validation.api", new String[] { "jakarta.validation-api-2.0.2.redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.websocket.api",
                new String[] { "jboss-websocket-api_1.1_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.ws.rs.api",
                new String[] { "jboss-jaxrs-api_2.1_spec-2.0.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.wsdl4j.api", new String[] { "wsdl4j-1.6.3.redhat-2.jar" }));
        moduls_7_4.add(new Module("javax.xml.bind.api",
                new String[] { "jboss-jaxb-api_2.3_spec-2.0.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("javax.xml.rpc.api.internal", new String[] { "" }));
        moduls_7_4.add(new Module("javax.xml.rpc.api",
                new String[] { "jboss-jaxrpc-api_1.1_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("javax.xml.soap.api", new String[] { "jboss-saaj-api_1.4_spec-1.0.2.Final-redhat-00002.jar",
                        "jboss-saaj-api_1.3_spec-1.0.6.Final-redhat-1.jar" }));
        moduls_7_4.add(new Module("javax.xml.stream.api", new String[] { "" }));
        moduls_7_4.add(new Module("javax.xml.ws.api",
                new String[] { "jboss-jaxws-api_2.3_spec-2.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("net.bytebuddy", new String[] { "byte-buddy-1.9.11.redhat-00003.jar" }));
        moduls_7_4.add(new Module("net.jcip", new String[] { "jcip-annotations-1.0.0.redhat-8.jar" }));
        moduls_7_4.add(new Module("nu.xom", new String[] { "xom-1.2.10.redhat-1.jar" }));
        moduls_7_4.add(new Module("org.aesh", new String[] { "aesh-extensions-1.8.0.redhat-00001.jar",
                "readline-2.2.0.redhat-00001.jar", "aesh-2.4.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.antlr", new String[] { "antlr-2.7.7.redhat-7.jar" }));
        moduls_7_4.add(new Module("org.apache.activemq.artemis.journal",
                new String[] { "lib", "artemis-commons-2.16.0.redhat-00022.jar",
                        "artemis-journal-2.16.0.redhat-00022.jar", "activemq-artemis-native-1.0.2.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.activemq.artemis", new String[] {
                "artemis-core-client-2.16.0.redhat-00022.jar", "artemis-selector-2.16.0.redhat-00022.jar",
                "artemis-server-2.16.0.redhat-00022.jar", "artemis-cli-2.16.0.redhat-00022.jar",
                "artemis-dto-2.16.0.redhat-00022.jar", "artemis-hqclient-protocol-2.16.0.redhat-00022.jar",
                "artemis-jdbc-store-2.16.0.redhat-00022.jar", "artemis-jms-client-2.16.0.redhat-00022.jar",
                "artemis-jms-server-2.16.0.redhat-00022.jar", "artemis-service-extensions-2.16.0.redhat-00022.jar",
                "artemis-tools-2.16.0.redhat-00022.jar" }));
        moduls_7_4.add(new Module("org.apache.activemq.artemis.protocol.hornetq",
                new String[] { "artemis-hornetq-protocol-2.16.0.redhat-00022.jar" }));
        moduls_7_4.add(
                new Module("org.apache.activemq.artemis.ra", new String[] { "artemis-ra-2.16.0.redhat-00022.jar" }));
        moduls_7_4.add(new Module("org.apache.avro", new String[] { "avro-1.7.6.redhat-2.jar" }));
        moduls_7_4.add(new Module("org.apache.commons.beanutils",
                new String[] { "commons-beanutils-1.9.4.redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.apache.commons.cli", new String[] { "commons-cli-1.4.0.redhat-00001.jar" }));
        moduls_7_4
                .add(new Module("org.apache.commons.codec", new String[] { "commons-codec-1.15.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.commons.collections",
                new String[] { "commons-collections-3.2.2.redhat-2.jar" }));
        moduls_7_4.add(new Module("org.apache.commons.io", new String[] { "commons-io-2.5.0.redhat-3.jar" }));
        moduls_7_4.add(new Module("org.apache.commons.lang", new String[] { "commons-lang-2.6.0.redhat-7.jar" }));
        moduls_7_4
                .add(new Module("org.apache.commons.lang3", new String[] { "commons-lang3-3.11.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.commons.logging", new String[] { "" }));
        moduls_7_4.add(new Module("org.apache.cxf.impl", new String[] { "cxf-rt-bindings-coloc-3.3.9.redhat-00001.jar",
                "cxf-rt-bindings-soap-3.3.9.redhat-00001.jar", "cxf-rt-bindings-xml-3.3.9.redhat-00001.jar",
                "cxf-rt-databinding-aegis-3.3.9.redhat-00001.jar", "cxf-rt-databinding-jaxb-3.3.9.redhat-00001.jar",
                "cxf-rt-features-clustering-3.3.9.redhat-00001.jar", "cxf-rt-frontend-jaxws-3.3.9.redhat-00001.jar",
                "cxf-rt-frontend-simple-3.3.9.redhat-00001.jar", "cxf-rt-management-3.3.9.redhat-00001.jar",
                "cxf-rt-security-3.3.9.redhat-00001.jar", "cxf-rt-security-saml-3.3.9.redhat-00001.jar",
                "cxf-rt-transports-http-3.3.9.redhat-00001.jar", "cxf-rt-transports-http-hc-3.3.9.redhat-00001.jar",
                "cxf-rt-transports-jms-3.3.9.redhat-00001.jar", "cxf-rt-transports-local-3.3.9.redhat-00001.jar",
                "cxf-rt-wsdl-3.3.9.redhat-00001.jar", "cxf-rt-ws-addr-3.3.9.redhat-00001.jar",
                "cxf-rt-ws-mex-3.3.9.redhat-00001.jar", "cxf-rt-ws-policy-3.3.9.redhat-00001.jar",
                "cxf-rt-ws-rm-3.3.9.redhat-00001.jar", "cxf-tools-common-3.3.9.redhat-00001.jar",
                "cxf-tools-java2ws-3.3.9.redhat-00001.jar", "cxf-tools-validator-3.3.9.redhat-00001.jar",
                "cxf-tools-wsdlto-core-3.3.9.redhat-00001.jar",
                "cxf-tools-wsdlto-databinding-jaxb-3.3.9.redhat-00001.jar",
                "cxf-tools-wsdlto-frontend-jaxws-3.3.9.redhat-00001.jar",
                "cxf-services-ws-discovery-api-3.3.9.redhat-00001.jar", "cxf-xjc-boolean-3.3.1.redhat-00001.jar",
                "cxf-xjc-bug986-3.3.1.redhat-00001.jar", "cxf-xjc-dv-3.3.1.redhat-00001.jar",
                "cxf-xjc-ts-3.3.1.redhat-00001.jar", "cxf-xjc-runtime-3.3.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.cxf",
                new String[] { "cxf-core-3.3.9.redhat-00001.jar", "cxf-rt-features-logging-3.3.9.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.cxf.services-sts",
                new String[] { "cxf-services-sts-core-3.3.9.redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.apache.cxf.ws-security", new String[] { "cxf-rt-ws-security-3.3.9.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.httpcomponents.core",
                new String[] { "httpclient-4.5.13.redhat-00001.jar", "httpcore-4.4.14.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.httpcomponents", new String[] { "httpcore-nio-4.4.14.redhat-00001.jar",
                "httpasyncclient-4.1.4.redhat-00001.jar", "httpmime-4.5.13.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.james.mime4j", new String[] { "apache-mime4j-0.6.0.redhat-7.jar" }));
        moduls_7_4.add(new Module("org.apache.log4j", new String[] { "" }));
        moduls_7_4
                .add(new Module("org.apache.logging.log4j.api", new String[] { "log4j-api-2.14.0.redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.apache.lucene.internal",
                new String[] { "lucene-misc-5.5.5.redhat-2.jar", "lucene-backward-codecs-5.5.5.redhat-2.jar" }));
        moduls_7_4.add(new Module("org.apache.lucene",
                new String[] { "lucene-analyzers-common-5.5.5.redhat-2.jar", "lucene-core-5.5.5.redhat-2.jar",
                        "lucene-facet-5.5.5.redhat-2.jar", "lucene-queries-5.5.5.redhat-2.jar",
                        "lucene-queryparser-5.5.5.redhat-2.jar" }));
        moduls_7_4.add(new Module("org.apache.neethi", new String[] { "neethi-3.1.1.redhat-1.jar" }));
        moduls_7_4.add(new Module("org.apache.openjpa", new String[] { "jipijapa-openjpa-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.apache.santuario.xmlsec", new String[] { "xmlsec-2.1.6.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.sshd",
                new String[] { "sshd-common-2.4.0.redhat-00001.jar", "sshd-core-2.4.0.redhat-00001.jar" }));
        moduls_7_4
                .add(new Module("org.apache.velocity", new String[] { "velocity-engine-core-2.2.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.ws.security", new String[] { "wss4j-bindings-2.2.6.redhat-00001.jar",
                "wss4j-policy-2.2.6.redhat-00001.jar", "wss4j-ws-security-common-2.2.6.redhat-00001.jar",
                "wss4j-ws-security-dom-2.2.6.redhat-00001.jar", "wss4j-ws-security-policy-stax-2.2.6.redhat-00001.jar",
                "wss4j-ws-security-stax-2.2.6.redhat-00001.jar", "jasypt-1.9.3.redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.apache.ws.xmlschema", new String[] { "xmlschema-core-2.2.5.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.xalan",
                new String[] { "serializer-2.7.1.redhat-12.jar", "xalan-2.7.1.redhat-12.jar" }));
        moduls_7_4.add(new Module("org.apache.xerces", new String[] { "xercesImpl-2.12.0.SP03-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.apache.xml-resolver", new String[] { "xml-resolver-1.2.0.redhat-12.jar" }));
        moduls_7_4
                .add(new Module("org.bouncycastle.bcmail", new String[] { "bcmail-jdk15on-1.68.0.redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.bouncycastle.bcpg", new String[] { "bcpg-jdk15on-1.68.0.redhat-00005.jar" }));
        moduls_7_4
                .add(new Module("org.bouncycastle.bcpkix", new String[] { "bcpkix-jdk15on-1.68.0.redhat-00005.jar" }));
        moduls_7_4
                .add(new Module("org.bouncycastle.bcprov", new String[] { "bcprov-jdk15on-1.68.0.redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.bouncycastle", new String[] { "" }));
        moduls_7_4.add(new Module("org.codehaus.jackson.jackson-core-asl",
                new String[] { "jackson-core-asl-1.9.13.redhat-00007.jar" }));
        moduls_7_4.add(new Module("org.codehaus.jackson.jackson-jaxrs",
                new String[] { "jackson-jaxrs-1.9.13.redhat-00007.jar" }));
        moduls_7_4.add(new Module("org.codehaus.jackson.jackson-mapper-asl",
                new String[] { "jackson-mapper-asl-1.9.13.redhat-00007.jar" }));
        moduls_7_4.add(
                new Module("org.codehaus.jackson.jackson-xc", new String[] { "jackson-xc-1.9.13.redhat-00007.jar" }));
        moduls_7_4.add(new Module("org.codehaus.jettison", new String[] { "jettison-1.4.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.codehaus.woodstox",
                new String[] { "woodstox-core-6.0.3.redhat-00001.jar", "stax2-api-4.2.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.dom4j", new String[] { "dom4j-2.1.3.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.eclipse.jdt.ecj", new String[] { "ecj-4.6.1.redhat-1.jar" }));
        moduls_7_4.add(
                new Module("org.eclipse.jgit", new String[] { "org.eclipse.jgit-5.10.0.202012080955-r-redhat-00001.jar",
                        "org.eclipse.jgit.ssh.apache-5.10.0.202012080955-r-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.eclipse.persistence",
                new String[] { "jipijapa-eclipselink-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.eclipse.yasson", new String[] { "yasson-1.0.5.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.fusesource.jansi", new String[] { "jansi-1.18.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.glassfish.jakarta.el", new String[] { "jakarta.el-3.0.3.redhat-00002.jar" }));
        moduls_7_4
                .add(new Module("org.glassfish.jakarta.json", new String[] { "jakarta.json-1.1.6.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.glassfish.javax.el", new String[] { "" }));
        moduls_7_4.add(new Module("org.glassfish.javax.enterprise.concurrent",
                new String[] { "jakarta.enterprise.concurrent-1.1.1.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.glassfish.javax.json", new String[] { "" }));
        moduls_7_4.add(new Module("org.glassfish.soteria",
                new String[] { "jakarta.security.enterprise-1.0.1.redhat-00002.jar" }));
        moduls_7_4.add(
                new Module("org.hibernate:4.1", new String[] { "jipijapa-hibernate4-1-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.hibernate:4.3", new String[] { "" }));
        moduls_7_4.add(new Module("org.hibernate:5.0", new String[] { "" }));
        moduls_7_4.add(new Module("org.hibernate:5.3", new String[] { "" }));
        moduls_7_4.add(new Module("org.hibernate.bytecodetransformer",
                new String[] { "wildfly-ormtransformer-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.hibernate.commons-annotations",
                new String[] { "hibernate-commons-annotations-5.0.5.Final-redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.hibernate.envers", new String[] { "" }));
        moduls_7_4.add(new Module("org.hibernate.infinispan", new String[] { "" }));
        moduls_7_4.add(new Module("org.hibernate.jipijapa-hibernate4-3",
                new String[] { "jipijapa-hibernate4-3-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.hibernate.jipijapa-hibernate5",
                new String[] { "jipijapa-hibernate5-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.hibernate.jipijapa-hibernate5-3",
                new String[] { "jipijapa-hibernate5-3-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.hibernate", new String[] { "hibernate-core-5.3.20.Final-redhat-00001.jar",
                "hibernate-envers-5.3.20.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.hibernate.search.backend-jms",
                new String[] { "hibernate-search-backend-jms-5.10.7.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.hibernate.search.engine",
                new String[] { "hibernate-search-engine-5.10.7.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.hibernate.search.orm",
                new String[] { "hibernate-search-orm-5.10.7.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.hibernate.search.serialization-avro",
                new String[] { "hibernate-search-serialization-avro-5.10.7.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.hibernate.validator.cdi",
                new String[] { "hibernate-validator-cdi-6.0.22.Final-redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.hibernate.validator",
                new String[] { "hibernate-validator-6.0.22.Final-redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.hornetq.client", new String[] { "hornetq-commons-2.4.7.Final-redhat-2.jar",
                "hornetq-core-client-2.4.7.Final-redhat-2.jar", "hornetq-jms-client-2.4.7.Final-redhat-2.jar" }));
        moduls_7_4.add(new Module("org.infinispan.cachestore.remote", new String[] { "" }));
        moduls_7_4.add(new Module("org.infinispan.client.hotrod",
                new String[] { "infinispan-client-hotrod-11.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.infinispan.commons",
                new String[] { "infinispan-commons-11.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.infinispan.component.annotations",
                new String[] { "infinispan-component-annotations-11.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.infinispan.hibernate-cache",
                new String[] { "infinispan-hibernate-cache-spi-11.0.9.Final-redhat-00001.jar",
                        "infinispan-hibernate-cache-commons-11.0.9.Final-redhat-00001.jar",
                        "infinispan-hibernate-cache-v53-11.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.infinispan", new String[] { "infinispan-core-11.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.infinispan.persistence.jdbc",
                new String[] { "infinispan-cachestore-jdbc-11.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.infinispan.persistence.remote",
                new String[] { "infinispan-cachestore-remote-11.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.infinispan.protostream", new String[] { "protostream-4.3.5.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.javassist", new String[] { "javassist-3.23.2.GA-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jaxen", new String[] { "jaxen-1.1.6.redhat-2.jar" }));
        moduls_7_4
                .add(new Module("org.jberet.jberet-core", new String[] { "jberet-core-1.3.7.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.appclient", new String[] { "wildfly-appclient-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.cli", new String[] { "wildfly-cli-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.clustering.common",
                new String[] { "wildfly-clustering-common-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.clustering.ejb3.infinispan", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.as.clustering.infinispan",
                new String[] { "wildfly-clustering-infinispan-extension-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.clustering.jgroups",
                new String[] { "wildfly-clustering-jgroups-extension-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.clustering.web.infinispan", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.as.cmp", new String[] { "wildfly-cmp-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.configadmin",
                new String[] { "wildfly-configadmin-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.connector", new String[] { "wildfly-connector-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.console:eap",
                new String[] { "hal-console-3.3.2.Final-redhat-00001-resources.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.controller",
                new String[] { "wildfly-controller-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.controller-client",
                new String[] { "wildfly-controller-client-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.core-security",
                new String[] { "wildfly-core-security-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.core-security-api",
                new String[] { "wildfly-core-security-api-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.deployment-repository",
                new String[] { "wildfly-deployment-repository-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.deployment-scanner",
                new String[] { "wildfly-deployment-scanner-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.domain-add-user", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.as.domain-http-error-context", new String[] { "dir" }));
        moduls_7_4.add(new Module("org.jboss.as.domain-http-error-context",
                new String[] { "wildfly-domain-http-error-context-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.domain-http-interface",
                new String[] { "wildfly-domain-http-interface-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.domain-management",
                new String[] { "wildfly-domain-management-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.ee", new String[] { "wildfly-ee-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.ejb3", new String[] { "wildfly-ejb3-7.4.0.GA-redhat-00005.jar", "timers" }));
        moduls_7_4.add(new Module("org.jboss.as.host-controller",
                new String[] { "wildfly-host-controller-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.jacorb", new String[] { "wildfly-jacorb-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.jaxr", new String[] { "wildfly-jaxr-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.jaxrs", new String[] { "wildfly-jaxrs-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.jdr", new String[] { "wildfly-jdr-7.4.0.GA-redhat-00005.jar", "resources" }));
        moduls_7_4.add(new Module("org.jboss.as.jmx", new String[] { "wildfly-jmx-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.jpa.hibernate:4", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.as.jpa", new String[] { "wildfly-jpa-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.jpa.openjpa", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.as.jpa.spi", new String[] { "jipijapa-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.jsf", new String[] { "wildfly-jsf-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.jsf-injection", new String[] {
                "wildfly-jsf-injection-7.4.0.GA-redhat-00005.jar", "weld-jsf-3.1.6.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.jsr77", new String[] { "wildfly-jsr77-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.logging", new String[] { "wildfly-logging-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.mail", new String[] { "wildfly-mail-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.management-client-content",
                new String[] { "wildfly-management-client-content-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.messaging", new String[] { "wildfly-messaging-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.modcluster", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.as.naming", new String[] { "wildfly-naming-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.network", new String[] { "wildfly-network-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.patching.cli", new String[] { "" }));
        moduls_7_4.add(
                new Module("org.jboss.as.patching", new String[] { "wildfly-patching-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.platform-mbean",
                new String[] { "wildfly-platform-mbean-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.pojo", new String[] { "wildfly-pojo-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.process-controller",
                new String[] { "wildfly-process-controller-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.product:eap", new String[] { "dir" }));
        moduls_7_4.add(
                new Module("org.jboss.as.protocol", new String[] { "wildfly-protocol-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.remoting", new String[] { "wildfly-remoting-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.sar", new String[] { "wildfly-sar-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.security", new String[] { "wildfly-security-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.security-api",
                new String[] { "wildfly-security-api-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.security-integration",
                new String[] { "wildfly-security-integration-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.security-plugins",
                new String[] { "wildfly-security-plugins-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.server", new String[] { "wildfly-server-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.standalone", new String[] { "" }));
        moduls_7_4.add(
                new Module("org.jboss.as.system-jmx", new String[] { "wildfly-system-jmx-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.threads", new String[] { "wildfly-threads-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.transactions",
                new String[] { "wildfly-transactions-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.vault-tool",
                new String[] { "wildfly-security-vault-tool-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.version", new String[] { "wildfly-version-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.web", new String[] { "wildfly-web-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.web-common", new String[] { "wildfly-web-common-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.webservices",
                new String[] { "wildfly-webservices-server-integration-7.4.0.GA-redhat-00005.jar",
                        "jbossws-cxf-resources-5.4.2.Final-redhat-00001-wildfly1900.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.webservices.server.integration", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.as.weld.beanvalidation",
                new String[] { "wildfly-weld-bean-validation-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.weld.common",
                new String[] { "wildfly-weld-common-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.weld.ejb", new String[] { "wildfly-weld-ejb-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.weld.jpa", new String[] { "wildfly-weld-jpa-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.weld", new String[] { "wildfly-weld-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.as.weld.spi", new String[] { "wildfly-weld-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.weld.transactions",
                new String[] { "wildfly-weld-transactions-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.weld.webservices",
                new String[] { "wildfly-weld-webservices-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.as.xts", new String[] { "wildfly-xts-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.jboss.classfilewriter",
                new String[] { "jboss-classfilewriter-1.2.4.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.common-beans",
                new String[] { "jboss-common-beans-2.0.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.deployers.jboss-service-deployer", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.dmr", new String[] { "jboss-dmr-1.5.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ejb.remote.protocol", new String[] { "" }));
        moduls_7_4.add(
                new Module("org.jboss.ejb-client", new String[] { "jboss-ejb-client-4.0.39.SP1-redhat-00001.jar" }));
        moduls_7_4
                .add(new Module("org.jboss.ejb3", new String[] { "jboss-ejb3-ext-api-2.3.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.genericjms",
                new String[] { ".", "generic-jms-ra-jar-2.0.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.iiop-client", new String[] { "jboss-iiop-client-1.0.1.Final-redhat-1.jar" }));
        moduls_7_4.add(new Module("org.jboss.integration.ext-content", new String[] { "bundled" }));
        moduls_7_4.add(
                new Module("org.jboss.invocation", new String[] { "jboss-invocation-1.6.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ironjacamar.api",
                new String[] { "ironjacamar-common-api-1.4.30.Final-redhat-00001.jar",
                        "ironjacamar-common-spi-1.4.30.Final-redhat-00001.jar",
                        "ironjacamar-core-api-1.4.30.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ironjacamar.impl",
                new String[] { "ironjacamar-common-impl-1.4.30.Final-redhat-00001.jar",
                        "ironjacamar-core-impl-1.4.30.Final-redhat-00001.jar",
                        "ironjacamar-deployers-common-1.4.30.Final-redhat-00001.jar",
                        "ironjacamar-validator-1.4.30.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ironjacamar.jdbcadapters",
                new String[] { "ironjacamar-jdbc-1.4.30.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.jandex", new String[] { "jandex-2.2.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.jaxbintros", new String[] { "jboss-jaxb-intros-1.0.3.GA-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.jboss-transaction-spi",
                new String[] { "jboss-transaction-spi-7.6.0.Final-redhat-1.jar" }));
        moduls_7_4.add(new Module("org.jboss.jts.integration",
                new String[] { "narayana-jts-integration-5.11.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.jts", new String[] { "narayana-jts-idlj-5.11.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.log4j.logmanager",
                new String[] { "log4j-jboss-logmanager-1.2.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.logging.commons.logging",
                new String[] { "commons-logging-jboss-logging-1.0.0.Final-redhat-1.jar" }));
        moduls_7_4.add(new Module("org.jboss.logging.jul-to-slf4j-stub",
                new String[] { "jul-to-slf4j-stub-1.0.1.Final-redhat-3.jar" }));
        moduls_7_4.add(new Module("org.jboss.logging", new String[] { "jboss-logging-3.4.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.logmanager.log4j2",
                new String[] { "log4j2-jboss-logmanager-1.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.logmanager", new String[] { "jboss-logmanager-2.1.18.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.marshalling",
                new String[] { "jboss-marshalling-2.0.11.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.marshalling.river",
                new String[] { "jboss-marshalling-river-2.0.11.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.metadata.appclient",
                new String[] { "jboss-metadata-appclient-13.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.metadata.common",
                new String[] { "jboss-metadata-common-13.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.metadata.ear",
                new String[] { "jboss-metadata-ear-13.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.metadata.ejb",
                new String[] { "jboss-metadata-ejb-13.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.metadata.web",
                new String[] { "jboss-metadata-web-13.0.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.migration.cli",
                new String[] { "jboss-server-migration-cli-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-core-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap6.4-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap6.4-to-eap7.4-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap7.0-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap7.1-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap7.2-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap7.3-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap7.3-to-eap7.4-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap7.4-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-eap7.4-to-eap7.4-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly8.2-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly9.0-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly10.0-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly10.1-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly11.0-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly12.0-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly13.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly14.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly15.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly16.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly17.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly18.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly19.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly20.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly21.0-server-1.10.0.Final-redhat-00007.jar",
                        "jboss-server-migration-wildfly22.0-server-1.10.0.Final-redhat-00007.jar" }));
        moduls_7_4.add(new Module("org.jboss.mod_cluster.container.spi",
                new String[] { "mod_cluster-container-spi-1.4.3.Final-redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.jboss.mod_cluster.core",
                new String[] { "mod_cluster-core-1.4.3.Final-redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.jboss.mod_cluster.load.spi",
                new String[] { "mod_cluster-load-spi-1.4.3.Final-redhat-00002.jar" }));
        moduls_7_4.add(new Module("org.jboss.msc", new String[] { "jboss-msc-1.4.12.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.narayana.compensations",
                new String[] { "compensations-5.11.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.narayana.rts",
                new String[] { "restat-api-5.11.3.Final-redhat-00001.jar", "restat-util-5.11.3.Final-redhat-00001.jar",
                        "restat-integration-5.11.3.Final-redhat-00001.jar",
                        "restat-bridge-5.11.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.narayana.txframework",
                new String[] { "txframework-5.11.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.remote-naming", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.remoting", new String[] { "jboss-remoting-5.0.20.SP1-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.remoting-jmx", new String[] { "remoting-jmx-3.0.4.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.remoting3", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.remoting3.remoting-jmx", new String[] { "" }));
        moduls_7_4.add(
                new Module("org.jboss.resteasy.jose-jwt", new String[] { "jose-jwt-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-atom-provider",
                new String[] { "resteasy-atom-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-cdi",
                new String[] { "resteasy-cdi-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-crypto",
                new String[] { "resteasy-crypto-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-jackson-provider",
                new String[] { "resteasy-jackson-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-jackson2-provider",
                new String[] { "resteasy-jackson2-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-jaxb-provider",
                new String[] { "resteasy-jaxb-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-jaxrs", new String[] {
                "resteasy-jaxrs-3.15.1.Final-redhat-00001.jar", "resteasy-client-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-jettison-provider",
                new String[] { "resteasy-jettison-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-jsapi",
                new String[] { "resteasy-jsapi-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-json-binding-provider",
                new String[] { "resteasy-json-binding-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-json-p-provider",
                new String[] { "resteasy-json-p-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-multipart-provider",
                new String[] { "resteasy-multipart-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-rxjava2",
                new String[] { "resteasy-rxjava2-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-spring", new String[] { "bundled" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-validator-provider",
                new String[] { "resteasy-validator-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-validator-provider-11", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.resteasy.resteasy-yaml-provider",
                new String[] { "resteasy-yaml-provider-3.15.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.security.negotiation",
                new String[] { "jboss-negotiation-common-3.0.6.Final-redhat-00001.jar",
                        "jboss-negotiation-extras-3.0.6.Final-redhat-00001.jar",
                        "jboss-negotiation-ntlm-3.0.6.Final-redhat-00001.jar",
                        "jboss-negotiation-spnego-3.0.6.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.security.xacml", new String[] { "jbossxacml-2.0.8.Final-redhat-8.jar" }));
        moduls_7_4.add(new Module("org.jboss.staxmapper", new String[] { "staxmapper-1.3.0.Final-redhat-1.jar" }));
        moduls_7_4.add(new Module("org.jboss.stdio", new String[] { "jboss-stdio-1.1.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.threads", new String[] { "jboss-threads-2.4.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.vfs", new String[] { "jboss-vfs-3.2.15.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.weld.api", new String[] { "weld-api-3.1.0.SP3-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.weld.core",
                new String[] { "weld-core-impl-3.1.6.Final-redhat-00001.jar", "weld-ejb-3.1.6.Final-redhat-00001.jar",
                        "weld-jta-3.1.6.Final-redhat-00001.jar", "weld-web-3.1.6.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.jboss.weld.probe", new String[] { "weld-probe-core-3.1.6.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.weld.spi", new String[] { "weld-spi-3.1.0.SP3-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.api", new String[] { "jbossws-api-1.1.2.Final-redhat-00001.jar" }));
        moduls_7_4
                .add(new Module("org.jboss.ws.common", new String[] { "jbossws-common-3.3.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.cxf.jbossws-cxf-client", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.ws.cxf.jbossws-cxf-factories",
                new String[] { "jbossws-cxf-factories-5.4.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.cxf.jbossws-cxf-server",
                new String[] { "jbossws-cxf-server-5.4.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.cxf.jbossws-cxf-transports-udp",
                new String[] { "jbossws-cxf-transports-udp-5.4.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.cxf.jbossws-cxf-transports-undertow",
                new String[] { "jbossws-cxf-transports-undertow-5.4.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.cxf.sts", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.ws.jaxws-client", new String[] {
                "jbossws-cxf-client-5.4.2.Final-redhat-00001.jar", "jbossws-cxf-jaspi-5.4.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.jaxws-undertow-httpspi",
                new String[] { "jaxws-undertow-httpspi-1.0.1.Final-redhat-1.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.saaj-impl", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.ws.spi", new String[] { "jbossws-spi-3.3.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.tools.common",
                new String[] { "jbossws-common-tools-1.3.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.ws.tools.wsconsume", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.ws.tools.wsprovide", new String[] { "" }));
        moduls_7_4.add(new Module("org.jboss.xnio", new String[] { "xnio-api-3.8.4.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.xnio.netty.netty-xnio-transport",
                new String[] { "netty-xnio-transport-0.1.9.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.xnio.nio", new String[] { "xnio-nio-3.8.4.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jboss.xts", new String[] { "jbossxts-5.11.3.Final-redhat-00001.jar",
                "jbosstxbridge-5.11.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jctools", new String[] { "jctools-core-2.1.2.redhat-00003.jar" }));
        moduls_7_4.add(new Module("org.jgroups.azure", new String[] { "jgroups-azure-1.3.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jgroups.kubernetes",
                new String[] { "jgroups-kubernetes-1.0.15.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.jgroups", new String[] { "jgroups-4.2.11.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.joda.time", new String[] { "joda-time-2.9.7.redhat-1.jar" }));
        moduls_7_4.add(new Module("org.jsoup", new String[] { "jsoup-1.8.3.redhat-2.jar" }));
        moduls_7_4.add(new Module("org.omg.api", new String[] { "" }));
        moduls_7_4.add(new Module("org.opensaml",
                new String[] { "opensaml-core-3.3.1.redhat-00002.jar", "opensaml-profile-api-3.3.1.redhat-00002.jar",
                        "opensaml-saml-api-3.3.1.redhat-00002.jar", "opensaml-saml-impl-3.3.1.redhat-00002.jar",
                        "opensaml-security-api-3.3.1.redhat-00002.jar", "opensaml-security-impl-3.3.1.redhat-00002.jar",
                        "opensaml-soap-api-3.3.1.redhat-00002.jar", "opensaml-xacml-api-3.3.1.redhat-00002.jar",
                        "opensaml-xacml-impl-3.3.1.redhat-00002.jar", "opensaml-xacml-saml-api-3.3.1.redhat-00002.jar",
                        "opensaml-xacml-saml-impl-3.3.1.redhat-00002.jar", "opensaml-xmlsec-api-3.3.1.redhat-00002.jar",
                        "opensaml-xmlsec-impl-3.3.1.redhat-00002.jar", "cryptacular-1.2.4.redhat-00001.jar",
                        "java-support-7.3.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.picketbox", new String[] { "picketbox-5.0.3.Final-redhat-00007.jar",
                "picketbox-infinispan-5.0.3.Final-redhat-00007.jar", "picketbox-commons-1.0.0.final-redhat-5.jar" }));
        moduls_7_4.add(
                new Module("org.picketlink.common", new String[] { "picketlink-common-2.5.5.SP12-redhat-00009.jar" }));
        moduls_7_4.add(
                new Module("org.picketlink.config", new String[] { "picketlink-config-2.5.5.SP12-redhat-00009.jar" }));
        moduls_7_4.add(
                new Module("org.picketlink.core.api", new String[] { "picketlink-api-2.5.5.SP12-redhat-00009.jar" }));
        moduls_7_4
                .add(new Module("org.picketlink.core", new String[] { "picketlink-impl-2.5.5.SP12-redhat-00009.jar" }));
        moduls_7_4.add(new Module("org.picketlink.federation.bindings",
                new String[] { "picketlink-wildfly8-2.5.5.SP12-redhat-00013.jar" }));
        moduls_7_4.add(new Module("org.picketlink.federation",
                new String[] { "picketlink-federation-2.5.5.SP12-redhat-00009.jar" }));
        moduls_7_4.add(new Module("org.picketlink.idm.api",
                new String[] { "picketlink-idm-api-2.5.5.SP12-redhat-00009.jar" }));
        moduls_7_4.add(
                new Module("org.picketlink.idm", new String[] { "picketlink-idm-impl-2.5.5.SP12-redhat-00009.jar" }));
        moduls_7_4.add(new Module("org.picketlink.idm.schema",
                new String[] { "picketlink-idm-simple-schema-2.5.5.SP12-redhat-00009.jar" }));
        moduls_7_4.add(new Module("org.picketlink", new String[] { "" }));
        moduls_7_4.add(new Module("org.projectodd.vdx",
                new String[] { "vdx-core-1.1.6.redhat-1.jar", "vdx-wildfly-1.1.6.redhat-1.jar" }));
        moduls_7_4.add(new Module("org.reactivestreams", new String[] { "reactive-streams-1.0.3.redhat-00003.jar" }));
        moduls_7_4.add(new Module("org.slf4j.ext", new String[] { "slf4j-ext-1.7.22.redhat-2.jar" }));
        moduls_7_4.add(
                new Module("org.slf4j.impl", new String[] { "slf4j-jboss-logmanager-1.1.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.slf4j", new String[] { "slf4j-api-1.7.22.redhat-2.jar" }));
        moduls_7_4.add(new Module("org.wildfly.client.config",
                new String[] { "wildfly-client-config-1.0.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.api",
                new String[] { "wildfly-clustering-api-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.ee.cache",
                new String[] { "wildfly-clustering-ee-cache-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.ee.hotrod",
                new String[] { "wildfly-clustering-ee-hotrod-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.ee.infinispan",
                new String[] { "wildfly-clustering-ee-infinispan-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.ee.spi",
                new String[] { "wildfly-clustering-ee-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.ejb.infinispan",
                new String[] { "wildfly-clustering-ejb-infinispan-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.ejb.spi",
                new String[] { "wildfly-clustering-ejb-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.infinispan.client",
                new String[] { "wildfly-clustering-infinispan-client-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.infinispan.marshalling",
                new String[] { "wildfly-clustering-infinispan-marshalling-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.infinispan.spi",
                new String[] { "wildfly-clustering-infinispan-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.jgroups.api",
                new String[] { "wildfly-clustering-jgroups-api-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.jgroups.spi",
                new String[] { "wildfly-clustering-jgroups-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.marshalling.api",
                new String[] { "wildfly-clustering-marshalling-api-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.marshalling.jboss",
                new String[] { "wildfly-clustering-marshalling-jboss-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.marshalling.protostream",
                new String[] { "wildfly-clustering-marshalling-protostream-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.marshalling.spi",
                new String[] { "wildfly-clustering-marshalling-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.server",
                new String[] { "wildfly-clustering-server-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.service",
                new String[] { "wildfly-clustering-service-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.singleton",
                new String[] { "wildfly-clustering-singleton-api-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.spi",
                new String[] { "wildfly-clustering-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.web.api",
                new String[] { "wildfly-clustering-web-api-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.web.cache",
                new String[] { "wildfly-clustering-web-cache-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.web.container",
                new String[] { "wildfly-clustering-web-container-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.web.hotrod",
                new String[] { "wildfly-clustering-web-hotrod-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.web.infinispan",
                new String[] { "wildfly-clustering-web-infinispan-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.web.spi",
                new String[] { "wildfly-clustering-web-spi-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.clustering.web.undertow",
                new String[] { "wildfly-clustering-web-undertow-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4
                .add(new Module("org.wildfly.common", new String[] { "wildfly-common-1.5.4.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.discovery",
                new String[] { "wildfly-discovery-client-1.2.1.Final-redhat-00001.jar" }));
        moduls_7_4.add(
                new Module("org.wildfly.embedded", new String[] { "wildfly-embedded-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.event.logger",
                new String[] { "wildfly-event-logger-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.batch.jberet",
                new String[] { "wildfly-batch-jberet-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.bean-validation",
                new String[] { "wildfly-bean-validation-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.clustering.singleton",
                new String[] { "wildfly-clustering-singleton-extension-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.clustering.web",
                new String[] { "wildfly-clustering-web-extension-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.core-management",
                new String[] { "wildfly-core-management-subsystem-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.core-management-client",
                new String[] { "wildfly-core-management-client-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.datasources-agroal",
                new String[] { "wildfly-datasources-agroal-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.discovery",
                new String[] { "wildfly-discovery-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.ee-security",
                new String[] { "wildfly-ee-security-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.elytron",
                new String[] { "wildfly-elytron-integration-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.health",
                new String[] { "wildfly-health-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(
                new Module("org.wildfly.extension.io", new String[] { "wildfly-io-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.messaging-activemq",
                new String[] { "wildfly-messaging-activemq-7.4.0.GA-redhat-00005.jar",
                        "artemis-wildfly-integration-1.0.2.redhat-1.jar", "META-INF" }));
        moduls_7_4.add(new Module("org.wildfly.extension.metrics",
                new String[] { "wildfly-metrics-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.mod_cluster",
                new String[] { "wildfly-mod_cluster-extension-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.picketlink",
                new String[] { "wildfly-picketlink-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.request-controller",
                new String[] { "wildfly-request-controller-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4
                .add(new Module("org.wildfly.extension.rts", new String[] { "wildfly-rts-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.security.manager",
                new String[] { "wildfly-security-manager-15.0.2.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.extension.undertow",
                new String[] { "wildfly-undertow-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.http-client.common",
                new String[] { "wildfly-http-client-common-1.1.5.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.http-client.ejb",
                new String[] { "wildfly-http-ejb-client-1.1.5.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.http-client.naming",
                new String[] { "wildfly-http-naming-client-1.1.5.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.http-client.transaction",
                new String[] { "wildfly-http-transaction-client-1.1.5.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.iiop-openjdk",
                new String[] { "wildfly-iiop-openjdk-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.mod_cluster.undertow",
                new String[] { "wildfly-mod_cluster-undertow-7.4.0.GA-redhat-00005.jar" }));
        moduls_7_4.add(new Module("org.wildfly.naming", new String[] { "" }));
        moduls_7_4.add(new Module("org.wildfly.naming-client",
                new String[] { "wildfly-naming-client-1.0.14.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.openssl",
                new String[] { "wildfly-openssl-java-2.1.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.security.elytron", new String[] { "" }));
        moduls_7_4.add(new Module("org.wildfly.security.elytron-private",
                new String[] { "wildfly-elytron-asn1-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-audit-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-auth-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-auth-server-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-auth-server-deprecated-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-auth-server-http-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-auth-server-sasl-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-auth-util-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-base-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-client-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-credential-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-credential-source-deprecated-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-credential-source-impl-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-credential-store-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-digest-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-encryption-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-basic-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-bearer-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-cert-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-digest-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-deprecated-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-external-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-form-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-spnego-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-sso-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-http-util-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-jacc-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-jaspi-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-json-util-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-keystore-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-mechanism-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-mechanism-digest-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-mechanism-http-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-mechanism-gssapi-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-mechanism-oauth2-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-mechanism-scram-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-password-impl-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-permission-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-provider-util-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-realm-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-realm-jdbc-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-realm-ldap-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-realm-token-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-auth-util-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-anonymous-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-deprecated-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-digest-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-entity-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-external-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-gs2-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-gssapi-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-localuser-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-oauth2-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-otp-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-plain-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-sasl-scram-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-security-manager-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-security-manager-action-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-ssl-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-util-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-x500-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-x500-cert-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-x500-cert-acme-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-x500-cert-util-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-x500-deprecated-1.15.3.Final-redhat-00001.jar",
                        "wildfly-elytron-x500-principal-1.15.3.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.security.elytron-web.undertow-server",
                new String[] { "undertow-server-1.9.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.security.elytron-web.undertow-server-servlet",
                new String[] { "undertow-server-servlet-1.9.0.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.wildfly.security.manager", new String[] { "" }));
        moduls_7_4.add(new Module("org.wildfly.transaction.client",
                new String[] { "wildfly-transaction-client-1.1.13.Final-redhat-00001.jar" }));
        moduls_7_4.add(new Module("org.yaml.snakeyaml", new String[] { "snakeyaml-1.26.0.redhat-00001.jar" }));
        moduls_7_4.add(new Module("sun.jdk", new String[] { "service-loader-resources" }));
        moduls_7_4.add(new Module("sun.scripting", new String[] { "service-loader-resources" }));
        moduls_7_4.add(new Module("wildflyee.api", new String[] { "" }));

    }
    
    
    @Override
    public Map<String, String> getDefaultAnothersBaseJarToModule() {
        Map<String, String> anothers = new HashMap<>();
        
        
        
        log.info("\n\n --------------------- Mòduls de JBoss 7.4 ------------------\n\n");
        
        
        // KEY es la base del jar !!!!  
        
        /*
         * anothers.put("activation", getMessageReplaceJarForModule(modulByModuleName, "javax.activation.api"));

        anothers.put("javax.activation-api", getMessageReplaceJarForModule(modulByModuleName, "javax.activation.api"));
        anothers.put("javax.activation", getMessageReplaceJarForModule(modulByModuleName, "javax.activation.api"));
         */
        anothers.put("jakarta.activation-api", getMessageReplaceJarForModule(modulByModuleName, "javax.activation.api"));
        
        anothers.put("javax.activation", getMessageReplaceJarForModule(modulByModuleName, "javax.activation.api"));
        
        
        anothers.put("javax.annotation-api", "El jar {0} està associat a JBoss 7.2. Ha de ser substituida per la"
                + "dependència [org.jboss.spec.javax.annotation:jboss-annotations-api_1.3_spec]");
        
       
        anothers.put("javax.annotation", "El jar {0} està associat a JBoss 7.2. Ha de ser substituida per la"
                + "dependència [org.jboss.spec.javax.annotation:jboss-annotations-api_1.3_spec]");
        
        
        
        
        
        
        
        
        // 
        anothers.put("jakarta.mail-api", "El jar {0} està associat a la dependència "
                + "[jakarta.mail:jakarta.mail-api] però aquesta ha de ser substituida per la "
                + "dependència [com.sun.mail:jakarta.mail] per profile -Djboss=7.4");
        
        
        
        anothers.put("javax.annotation-api", getMessageReplaceJarForModule(modulByModuleName, "javax.annotation.api"));
        
        
        // jboss-annotations-api_1.2_spec-1.0.2.Final.jar
        anothers.put("jboss-annotations-api_1.2_spec", getMessageReplaceJarForModule(modulByModuleName, "javax.annotation.api"));
        
        
        //anothers.put("javax.ejb-api", getMessageReplaceJarForModule(modulByModuleName, "javax.ejb.api")); 
        
        anothers.put("javax.jws-api", getMessageReplaceJarForModule(modulByModuleName, "javax.jws.api"));
        anothers.put("jakarta.jws-api", getMessageReplaceJarForModule(modulByModuleName, "javax.jws.api"));
        
        
        
        /*anothers.put("javax.transaction-api",
                getMessageReplaceJarForModule(modulByModuleName, "javax.transaction.api"));
        anothers.put("jaxb-core", getMessageReplaceJarForModule(modulByModuleName, "com.sun.xml.bind")); */
        
        // jakarta.xml.bind-api-2.3.2.jar
        anothers.put("jakarta.xml.bind-api", getMessageReplaceJarForModule(modulByModuleName, "javax.xml.bind.api"));
       
        // javax.xml.soap-api-1.4.0.jar
        anothers.put("javax.xml.soap-api", getMessageReplaceJarForModule(modulByModuleName, "javax.xml.soap.api"));
        
        // jaxws-api-2.3.1.jar
        anothers.put("jaxws-api", getMessageReplaceJarForModule(modulByModuleName, "javax.xml.ws.api"));
        
        
        
        //jsr311-api-1.1.1.jar
        anothers.put("jsr311-api", getMessageReplaceJarForModule(modulByModuleName, "javax.ws.rs.api"));

        return anothers;
    }
}
