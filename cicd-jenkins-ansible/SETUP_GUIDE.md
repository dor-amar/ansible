# Setup Guide for CI/CD Pipeline Project

## Prerequisites

1. Jenkins Server Requirements:
   ```bash
   - Jenkins installed and running
   - Docker installed on Jenkins server
   - Ansible installed on Jenkins server
   - Git installed
   ```

2. Required Jenkins Plugins:
   ```
   - Docker Pipeline
   - Ansible
   - Git
   - GitHub Integration
   - Pipeline
   - Pipeline: GitHub
   ```

## Step 1: Jenkins Initial Setup

1. Install Required Plugins:
   ```
   Jenkins Dashboard → Manage Jenkins → Plugins → Available
   Search and install all required plugins
   ```

2. Configure Jenkins Credentials:
   ```
   Jenkins Dashboard → Manage Jenkins → Credentials → System → Global credentials
   
   Add the following credentials:
   a. Docker Registry credentials
      - Kind: Username with password
      - ID: docker-registry-credentials
      - Description: Docker Registry Access
      - Username: [your-registry-username]
      - Password: [your-registry-password]

   b. GitHub credentials (if repository is private)
      - Kind: Username with password
      - ID: github-credentials
      - Description: GitHub Access
      - Username: [your-github-username]
      - Password: [your-github-token]
   ```

## Step 2: Configure GitHub Webhook

1. In GitHub:
   ```
   Repository → Settings → Webhooks → Add webhook
   - Payload URL: https://[your-jenkins-url]/github-webhook/
   - Content type: application/json
   - Events: Just the push event
   ```

2. Test webhook:
   ```
   - After saving, GitHub will send a ping event
   - Check if it shows a green checkmark
   ```

## Step 3: Create Jenkins Pipeline

1. Create New Pipeline:
   ```
   Jenkins Dashboard → New Item
   - Enter name: [your-project-name]
   - Choose: Pipeline
   - Click OK
   ```

2. Configure Pipeline:
   ```
   In Pipeline Configuration:
   - Definition: Pipeline script from SCM
   - SCM: Git
   - Repository URL: [your-repository-url]
   - Branch Specifier: */main
   - Script Path: Jenkinsfile
   ```

## Step 4: Configure Ansible Inventory

1. Update Inventory File:
   ```
   Edit ansible/inventory/hosts.yml:
   - Replace IP addresses with your actual server IPs
   - Update ansible_user with correct SSH users
   - Ensure SSH key-based authentication is set up
   ```

2. Test Ansible Connectivity:
   ```bash
   cd ansible
   ansible all -i inventory/hosts.yml -m ping
   ```

## Step 5: Docker Registry Setup

1. Update Environment Variables:
   ```
   Edit Jenkinsfile:
   DOCKER_REGISTRY = '[your-registry-url]'
   DOCKER_IMAGE = '[your-image-name]'
   ```

2. Ensure Registry Access:
   ```bash
   # Test Docker login on Jenkins server
   docker login [your-registry-url]
   ```

## Step 6: First Run

1. Manual Pipeline Test:
   ```
   Jenkins Dashboard → [your-project-name] → Build Now
   ```

2. Monitor Build:
   ```
   Check each stage:
   - Checkout
   - Build Docker Image
   - Push to Registry
   - Deploy with Ansible
   ```

## Troubleshooting Guide

### Jenkins Issues:
1. Pipeline fails at checkout:
   - Check GitHub credentials
   - Verify repository URL
   - Ensure Jenkins has Git installed

2. Docker build fails:
   - Check Docker daemon is running
   - Verify Dockerfile exists in repository
   - Check Jenkins user is in docker group

3. Ansible deployment fails:
   - Verify inventory file
   - Check SSH access to servers
   - Ensure Ansible is installed correctly

### Common Fixes:

1. Docker Permission Issues:
   ```bash
   # Add Jenkins user to docker group
   sudo usermod -aG docker jenkins
   sudo systemctl restart jenkins
   ```

2. Ansible SSH Issues:
   ```bash
   # Generate SSH key for Jenkins user
   sudo -u jenkins ssh-keygen
   # Copy key to target servers
   ssh-copy-id -i /var/lib/jenkins/.ssh/id_rsa.pub [target-server-user]@[target-server]
   ```

3. Registry Authentication:
   ```bash
   # Test registry access
   docker login [registry-url]
   # Check credentials in Jenkins
   ```

## Validation Steps

1. Code Push Test:
   ```bash
   git commit --allow-empty -m "Test CI/CD pipeline"
   git push origin main
   ```

2. Check Pipeline Triggers:
   ```
   - Verify GitHub webhook delivery
   - Check Jenkins pipeline started automatically
   - Monitor build progress
   ```

3. Verify Deployment:
   ```bash
   # Check container on target server
   ssh [target-server]
   docker ps | grep [your-app-name]
   ```

## Security Recommendations

1. Credentials Protection:
   ```
   - Use Jenkins Credential Store
   - Never store credentials in code
   - Use environment variables for sensitive data
   ```

2. Access Control:
   ```
   - Implement Jenkins authentication
   - Use GitHub branch protection
   - Restrict deployment server access
   ```

3. Network Security:
   ```
   - Use HTTPS for webhooks
   - Implement proper firewall rules
   - Secure Docker registry access
   ```

## Maintenance

Regular checks:
```bash
# Check Jenkins logs
tail -f /var/log/jenkins/jenkins.log

# Monitor disk space
df -h

# Check Docker storage
docker system df

# Verify Ansible connectivity
ansible all -i inventory/hosts.yml -m ping
```

Remember to:
- Regularly update Jenkins plugins
- Monitor pipeline execution times
- Keep backups of Jenkins configuration
- Review and rotate credentials
- Test the pipeline in development first