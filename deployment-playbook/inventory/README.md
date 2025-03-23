# Inventory Structure

This directory contains the Ansible inventory configuration for different environments.

## Directory Structure 

## Usage

To run playbooks against specific environments:

```bash
# For development
ansible-playbook -i inventory/hosts.yml playbook.yml --limit development

# For staging
ansible-playbook -i inventory/hosts.yml playbook.yml --limit staging

# For production
ansible-playbook -i inventory/hosts.yml playbook.yml --limit production
```

## Environment Details

### Development
- 2 development servers
- Configured for debugging and testing
- Limited resources allocation

### Staging
- 2 staging servers
- Mirror of production configuration
- Used for pre-release testing

### Production
- 3 production servers
- High availability configuration
- Maximum resource allocation
- Debug disabled

## Variables

Each environment has its own variable file in `group_vars/` with specific configurations for:
- Container names
- Image sources
- Port mappings
- Resource limits
- Environment-specific settings

## Security Notes

- Ensure to use vault for sensitive information
- Keep production credentials separate and encrypted
- Use different SSH keys for different environments 