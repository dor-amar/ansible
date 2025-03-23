# Setting up GitHub Webhook with Jenkins

## Jenkins Configuration

1. Install Required Plugins
   ```
   Jenkins Dashboard -> Manage Jenkins -> Manage Plugins -> Available
   Install these plugins:
   - GitHub
   - GitHub Integration
   ```

2. Configure GitHub Server in Jenkins
   ```
   Jenkins Dashboard -> Manage Jenkins -> Configure System -> GitHub
   Add GitHub Server:
   - Name: GitHub
   - API URL: https://api.github.com
   - Credentials: Add GitHub Personal Access Token
   ```

3. Get Jenkins Webhook URL
   ```
   Your webhook URL will be:
   https://your-jenkins-url/github-webhook/
   ```

## GitHub Configuration

1. Go to your GitHub repository

2. Click on "Settings" -> "Webhooks" -> "Add webhook"

3. Configure the webhook:
   ```
   Payload URL: https://your-jenkins-url/github-webhook/
   Content type: application/json
   Secret: (Optional but recommended)
   
   Select events:
   - Push events
   - Pull request events (if needed)
   ```

4. Click "Add webhook"

## Testing the Setup

1. Make a small change to your repository
2. Commit and push to GitHub
3. Check Jenkins for automatic trigger

## Troubleshooting

1. Check webhook delivery in GitHub:
   ```
   Repository Settings -> Webhooks -> Click on webhook -> Recent Deliveries
   ```

2. Check Jenkins logs:
   ```
   Jenkins Dashboard -> Manage Jenkins -> System Log
   ```

3. Common issues:
   - Jenkins URL not accessible from GitHub
   - Wrong webhook URL
   - Missing credentials
   - Plugin configuration issues 