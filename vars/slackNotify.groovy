// SlackChannel
// currentBuils.currentResult
// Script is for Slack notifications.

def init(CHANNEL) {
  slackSend channel: CHANNEL, color: 'good', message: "JobStarted : ${env.JOB_NAME} ${env.BUILD_NUMBER}"
}

def call(CHANNEL, String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend  channel: CHANNEL, color: "good", message: "JobName : ${env.JOB_NAME} \nBuildNo : ${env.BUILD_NUMBER} \nStatus : SUCCESS"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend  channel: CHANNEL, color: "danger", message: "JobName : ${env.JOB_NAME} \nBuildNo : ${env.BUILD_NUMBER} \nStatus : FAILURE"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend  channel: CHANNEL, color: "warning", message: "JobName : ${env.JOB_NAME} \nBuildNo : ${env.BUILD_NUMBER} \nStatus : UNSTABLE"
  }
  else {
    slackSend  channel: CHANNEL, color: "danger", message: "JobName : ${env.JOB_NAME} \nBuildNo : ${env.BUILD_NUMBER} \nStatus : ABORTED"
  }
}



