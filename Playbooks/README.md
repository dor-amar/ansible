# Ansible Playbook

This repository contains an Ansible playbook to manage users and groups on remote servers. It demonstrates the basics of using Ansible for configuration management.

## What is an Ansible Playbook?

Ansible playbooks are a way of automating the execution of tasks on remote systems. They are written in YAML, a human-readable data serialization standard, making them easy to read and write. Playbooks are used to define a set of operations, called tasks, that should be executed on a group of hosts.


## Playbooks Directory

The `playbooks` directory contains various Ansible playbooks, each designed to automate different tasks. Below is a brief description of each playbook:

- **`check_disk_space.yaml`**: A playbook to check disk space usage on servers. It retrieves and displays disk usage statistics.
- **`conditional_playbook.yaml`**: Demonstrates conditional task execution based on system facts, such as enabling SELinux only on RedHat systems.
- **`create_files.yaml`**: Creates multiple files in a specified directory using a loop, illustrating how to manage repetitive tasks.
- **`create_users_groups.yaml`**: Creates users and groups on the target systems, managing user accounts and permissions.
- **`deploy_static_website.yaml`**: Deploys a static website by copying content to the web server's document root and ensuring the web server is running.
- **`index.html`**: An example HTML file used by the `deploy_static_website.yaml` playbook to serve as the website's homepage.
- **`install_apache_specific.yaml`**: Installs the Apache web server, with tasks tailored for different operating systems (e.g., Amazon Linux).
- **`install_apache.yaml`**: Installs and starts the Apache web server on the target hosts.
- **`inventory.ini`**: The inventory file listing the target hosts for the playbooks, specifying connection details like SSH user and key.
- **`manage_docker_containers.yaml`**: Manages Docker containers, including installing Docker, pulling images, and running containers.
- **`manage_packages.yaml`**: Installs, updates, or removes packages on the target systems using package managers like `yum` or `apt`.
- **`setup_firewall.yaml`**: Sets up basic firewall rules to allow or restrict traffic based on ports and services.
- **`site.yaml`**: A general-purpose playbook template for setting up web applications or services.

Each playbook in this directory serves as an example of how to use Ansible to automate various system administration tasks. Feel free to explore and customize these playbooks according to your needs.

## Running Playbooks

To run a playbook, use the following command:

```sh
ansible-playbook -i inventory.ini playbook_name.yml
```

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