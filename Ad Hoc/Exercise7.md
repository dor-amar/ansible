## Installing and Removing Packages
Command:
```sh
ansible all -i inventory.ini -m yum -a "name=nginx state=present" --become -K
ansible all -i inventory.ini -m yum -a "name=nginx state=absent" --become -K
```
### Exercise:

1. Install and then remove the nginx package on all hosts. Observe the changes and understand the package management process with Ansible.
