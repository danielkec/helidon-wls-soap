# https://docs.oracle.com/en/middleware/standalone/weblogic-server/14.1.1.0/wlprg/maven.html#GUID-C6FC7582-2D1C-4EA5-B000-71AE9A2F2B05
cd /u01/oracle/oracle_common/plugins/maven/com/oracle/maven/oracle-maven-sync/14.1.1
mvn install:install-file -DpomFile=oracle-maven-sync-14.1.1.pom -Dfile=oracle-maven-sync-14.1.1.jar
mvn com.oracle.maven:oracle-maven-sync:push -DoracleHome=/u01/oracle/
