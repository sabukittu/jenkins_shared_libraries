
def init(CHANNEL) {
  slackSend channel: CHANNEL, color: 'good', message: "JobStarted : ${env.JOB_NAME} ${env.BUILD_NUMBER}"
}

def call(CHANNEL) {
  slackSend channel: CHANNEL, color: "good", message: "JobName : ${env.JOB_NAME} \nBuildNo : ${env.BUILD_NUMBER} \nStatus : ${currentBuild.currentResult}"
}
