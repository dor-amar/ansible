# CI/CD Pipeline with Jenkins and Ansible

## GitHub Webhook Setup

This pipeline automatically triggers on GitHub pushes. To set up:

1. Jenkins Configuration:
   ```bash
   # Install required plugins
   jenkins-plugin-cli --plugins github github-integration
   ```

2. GitHub Configuration:
   - Go to repository settings
   - Add webhook: `https://your-jenkins-url/github-webhook/`
   - Select: `application/json` content type
   - Choose events to trigger

3. Verify Setup:
   - Push a change to repository
   - Check Jenkins for automatic trigger

See detailed instructions in `docs/github-webhook-setup.md`

## Pipeline Features

- Automatic triggers on GitHub push
- Docker image building and publishing
- Automated deployment to development
- Manual approval for staging/production
- Version tracking with git commits

## Usage

### Automatic Deployments
- Push to main/master -> Automatic deployment to development

### Manual Deployments
- Go to Jenkins pipeline
- Click "Build with Parameters"
- Select environment
- Click Build

## Prerequisites

- Docker
- Jenkins
- Ansible
- Git

## Quick Start

1. Clone this repository:
```bash
git clone https://github.com/your-org/cicd-jenkins-ansible.git
cd cicd-jenkins-ansible
```

2. Run the setup script:
```bash
./scripts/setup.sh local
```

3. Configure Jenkins:
   - Install suggested plugins
   - Create admin user
   - Configure GitHub webhook
   - Add credentials for GitHub and deployment servers

4. Update inventory:
   - Edit `ansible/inventory/hosts.yml` with your server details
   - Update group variables in `ansible/inventory/group_vars/`

5. Customize build and test scripts:
   - Modify `scripts/build.sh` for your application
   - Modify `scripts/test.sh` for your test suite

## Directory Structure 