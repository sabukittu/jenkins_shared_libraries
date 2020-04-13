// AWS_ACCESS_KEY_ID
// AWS_SECRET_ACCESS_KEY
// JENKINS_USER_ID
// JENKINS_API_TOKEN
// This script creates a jenkins slave EC2 Instance and
// register the instance to node configs.

def call() {
	node ("master") {
		checkout (
			[$class															: 'GitSCM', 
				branches													: [[name: '*/dev']], 
				doGenerateSubmoduleConfigurations	: false, 
				extensions												: [], 
				submoduleCfg 											: [], 
				userRemoteConfigs									: [[url: 'https://github.com/sabukittu/terraform.git']]
			]
		)
		stage ("SlaveLanuch") {
			sh "terraform init"
			sh "terraform plan -out=ec2plan"
			sh "terraform apply ec2plan"
			sh "./script.sh"
			sh "wget ${env.JENKINS_URL}jnlpJars/jenkins-cli.jar"
      sh "java -jar jenkins-cli.jar -s ${env.JENKINS_URL} reload-configuration"
      sh "sleep 120"
		}
	}
}

