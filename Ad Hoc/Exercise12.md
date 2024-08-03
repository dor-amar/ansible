## Gathering Information About Remote Nodes

Command:
```sh
ansible server1 -i inventory.ini -m setup
ansible server1 -i inventory.ini -m setup -a "gather_subset=min"
ansible server1 -i inventory.ini -m setup -a "filter=*ipv*"
ansible all -i inventory.ini -a "df -h"

```
### Exercise:

1. Use the setup module to gather and filter system information from remote nodes. Explore the gathered data to understand the remote environment.





