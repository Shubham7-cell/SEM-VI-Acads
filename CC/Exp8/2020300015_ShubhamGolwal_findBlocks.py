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

s = 1
for i in leaders[1:]:
    blocks.append(inp[s-1:i-1])
    s = i
blocks.append(inp[s-1:])

for i, b in enumerate(blocks):
    print("Block: B"+str(i+1), "->", b)

adjmat = [[] for i in blocks]


def getblock(ip):
    res = [-1, -1]
    global leaders

    for i, lead in enumerate(leaders):
        if ip[0] >= lead:
            res[0] = i+1
        if ip[1] >= lead:
            res[1] = i+1

    return res


for i in nodes:
    res = getblock(i)
    adjmat[res[0]].append(res[1])

# print()
# print("===ADJ.MAT.===")
# print(adjmat[1:])
# print()

print("--------OUTPUT---------")
for i, block in enumerate(blocks):
    for b in block:
        if 'goto' in b:
            z = re.findall(r'goto\([0-9]\)', b)
            kkk = int(z[0][5:-1])
            ind = b.find('goto(')
            print(f"{b[:ind+5]} B{getblock((kkk,kkk))[0]} )")
        else:
            print(b)
print("-----------------------")
