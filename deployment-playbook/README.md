# Docker Deployment Playbooks

This directory contains two different approaches to deploying Docker containers using Ansible:

1. Shell-based approach (`deploy-docker-shell.yml`)
2. Module-based approach (`deploy-docker-module.yml`)

## Comparison of Approaches

### Shell-based Approach (`deploy-docker-shell.yml`)
- Uses direct shell commands
- More familiar to those coming from shell scripting
- Less idiomatic Ansible
- More verbose
- Less error handling
- Harder to maintain
- Might break with different shell environments

### Module-based Approach (`deploy-docker-module.yml`)
- Uses Ansible modules
- More idiomatic Ansible
- Better error handling
- More maintainable
- More portable
- Better idempotency
- Better security

## Usage

To run the shell-based playbook:
```bash
ansible-playbook -i inventory/hosts.yml deploy-docker-shell.yml
```

To run the module-based playbook:
```bash
ansible-playbook -i inventory/hosts.yml deploy-docker-module.yml
```

## Environment Selection

To target specific environments:
```bash
# For development
ansible-playbook -i inventory/hosts.yml deploy-docker-module.yml --limit development

# For staging
ansible-playbook -i inventory/hosts.yml deploy-docker-module.yml --limit staging

# For production
ansible-playbook -i inventory/hosts.yml deploy-docker-module.yml --limit production
```

## Best Practices

1. Prefer the module-based approach for production use
2. Use shell-based approach only when modules are not available
3. Always test in development environment first
4. Use version tags for images instead of 'latest'
5. Implement proper error handling
6. Use variables for configurable values

## Notes

- The shell-based approach is provided for educational purposes
- For production deployments, always use the module-based approach
- Both playbooks achieve the same result but with different methodologies

## Prerequisites

- Ansible 2.9 or higher installed on the control node
- Target hosts with SSH access
- Basic understanding of Ansible and Docker concepts

## Repository Structure 

## Configuration

### Inventory Setup

Create an inventory file (`inventory.yml`) with your target hosts:

```yaml
all:
  children:
    docker_hosts:
      hosts:
        your-server:
          ansible_host: your-server-ip
          ansible_user: your-ssh-user
```

### Playbook Variables

The playbook (`deploy-docker.yml`) includes the following default variables that you can customize:

- `container_name`: Name of the Docker container
- `image_name`: Docker image to deploy
- `container_port`: Container's internal port
- `host_port`: Host port to map to container port

## Customization

To deploy a different Docker image or modify the configuration:

1. Edit the variables in `deploy-docker.yml`:
   ```yaml
   vars:
     container_name: "your-app-name"
     image_name: "your-image:tag"
     container_port: your-container-port
     host_port: your-host-port
   ```

2. Run the playbook with the updated configuration.

## Features

- Automated Docker installation
- Docker image pulling
- Container deployment with port mapping
- Automatic container restart on failure

## Troubleshooting

Common issues and solutions:

1. **Docker installation fails**
   - Ensure target host has internet access
   - Check system requirements
   - Verify apt cache is updated

2. **Container fails to start**
   - Check if ports are already in use
   - Verify image exists and is compatible
   - Check container logs

## Contributing

Feel free to contribute to this example by:
1. Forking the repository
2. Creating a feature branch
3. Submitting a pull request

## License

MIT License

## Author

[Your Name] 