import re
inp = []
f = open("i10.txt", "r")
for x in f:
inp.append(x)
leaders = [1]
nodes = []
for j, i in enumerate(inp):
z = re.findall(r'goto\([0-9]\)', i)
if len(z) > 0:
leader = int(z[0][5:-1])
if 'if ' in i:
nodes.append((j+1, j+2))
print("Adding ", (j+1, j+2), "to nodes list")
elif (j+1, j+2) in nodes:
nodes.remove((j+1, j+2))
print("Removing ", (j+1, j+2), "from nodes list")
nodes.append((j+1, leader))
print("Adding ", (j+1, leader), "to nodes list")
if leader not in leaders:
leaders.append(leader)
if (leader-1, leader) not in nodes:
print("Adding ", (leader-1, leader), "to nodes list")
nodes.append((leader-1, leader))
if j+2 not in leaders:
leaders.append(j+2)
print()
print("====NODES====")
nodes = list(set(nodes))
print(nodes, '\n')
print("===LEADER===")
leaders.sort()
print(leaders, '\n')
blocks = []
