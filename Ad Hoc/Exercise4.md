## Running Ansible Modules
Command:
```sh
ansible server1 -i inventory.ini -m yum -a "name=tree state=present" --become
```
### Exercise:

1. Use the yum module to install the tree package on a specified server. Replace apt with yum or dnf depending on your server's OS.


