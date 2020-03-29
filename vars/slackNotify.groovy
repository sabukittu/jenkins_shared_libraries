
def call(CHANNEL) {
	slackSend channel: CHANNEL, color: 'good', message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
}