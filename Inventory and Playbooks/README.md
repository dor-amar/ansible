# Ansible Playbook: User and Group Management

This repository contains an Ansible playbook to manage users and groups on remote servers. It demonstrates the basics of using Ansible for configuration management.

## Prerequisites

Before running the playbook, ensure you have the following:

1. **Ansible Installed**: Ansible must be installed on the control node (your local machine or a dedicated server).
2. **SSH Access**: SSH access to the target servers is required. The SSH private key should be correctly set up and accessible.

## Inventory File

The `inventory.ini` file lists the target servers that Ansible will manage. It should include the IP addresses or hostnames of the servers and the username used for SSH access.

### Example `inventory.ini`

```ini
[webservers]
52.58.222.174 ansible_user=ec2-user
```

### Command to Run a Playbook

```shell
ansible-playbook -i inventory.ini create_users_groups.yaml --private-key=/path/to/your/private/key
```
