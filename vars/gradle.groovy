def call(){
	echo "call(); gradle.groovy";
    figlet "gradle";

	String paramStage = params.paramStage;
    echo "paramStage ${paramStage}";

    sh "env.GIT_BRANCH";

	/*
	if (paramStage=="") {
		echo "Ejecutar todo";
		etapas();		
	} else {
		echo "Ejecutar solo las configuradas";
		def pasadas = paramStage.split(":");
		etapas(pasadas);
	}
	*/
}

/*
def etapas(pasadas=['build','test','sonar','run','rest','nexus']){
    Boolean noEncontrada = false;

	if(pasadas.contains("build") || pasadas.contains("test")){
		stage('build & test') {
			echo env.STAGE_NAME
			//Usar el gradlewrapper, incluido en el repo
			sh './gradlew clean build'
		}
    } else {
        noEncontrada = true;
    }
	if(pasadas.contains("sonar")){
		stage('sonar') {
			echo env.STAGE_NAME
			//Nombre en SonarQubeScanner en AdminJenkins/ConfigureTools/SonarQubeScanner
			def scannerHome = tool 'sonar-scanner';
			//Nombre en AdminJenkins/Configuración Global/SonarQube Servers
		    withSonarQubeEnv('sonar') { 
		    	// If you have configured more than one global server connection, you can specify its name
				sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
			}
		}
    } else {
        noEncontrada = true;
    }
	if(pasadas.contains("run")){
		stage('run') {
			echo env.STAGE_NAME

			sh 'nohup bash ./gradlew bootRun &'
		}
    } else {
        noEncontrada = true;
    }
	if(pasadas.contains("rest")){
		stage('rest') {
			echo env.STAGE_NAME

			//sh './gradle build'
			sh "sleep 30 && curl -X GET 'http://localhost:8082/rest/mscovid/test?msg=testing'"
		}
    } else {
        noEncontrada = true;
    }
	if(pasadas.contains("nexus")){
		stage('nexus') {
			echo env.STAGE_NAME

			nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: './build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.0']]]
		}
	 } else {
        noEncontrada = true;
    }
    if(noEncontrada){
        echo "Tarea(s) ${pasadas} no encontrada(s)";
    }
}
*/
return this;
