program = []
macros = []
defTab = []
nameTab = {}
param = {}
expandedMacros = []

def readFile():
    f = open('exp10\input_macro.txt', 'r')
    for line in f:
        program.append(line.strip().split())


def readMacros():
    flag = 0
    curr_macro = ''
    index = -1
    nParams = []
    for line in program:
        index += 1
        if not flag:
            if (len(line) > 1 and line[1] == 'MACRO'):
                flag = 1
                curr_macro = line[0]
                nameTab[line[0]] = [len(defTab), 0]
                temp = line.copy()

                if (len(temp) > 2):
                    params = temp[2]
                    nParams = params.split(',')
                    temp.pop(-1)
                    for i in nParams:
                        temp.append(i)
                temp.remove('MACRO')
                defTab.append(temp)

        else:
            if (line[0] == 'MEND'):
                flag = 0
                defTab.append(line)
                end = len(defTab) - 1
                nameTab[curr_macro][1] = end
                normalizeDefinition(nParams, curr_macro)

            else:
                defTab.append(line)


def normalizeDefinition(params, macro):
    start, end = nameTab[macro]
    for i in range(start+1, end):
        line = defTab[i]
        if (len(line) > 1):
            action = line[-1]
            for j in range(len(params)):
                action = action.replace(params[j], '?'+str(j+1))
                defTab[i][-1] = action


def expandMacro(line):
    param = []
    macro = ""
    flag = None
    if (line[0] in nameTab.keys()):
        macro = line[0]
    else:
        flag = line[0]
        macro = line[1]

    if (len(line) > 1):
        param = line[-1].split(",")

    first_line = line.copy()
    first_line[0] = "//" + first_line[0]
    first_line.append("\t//Commented Line")
    expandedMacros.append(first_line)

    f = open('argtab.txt', "a")

    f.write(f"Macro {macro} with parameters:\n")

    for i in range(len(param)-1):
        f.write(f"{param[i]}, ")
    f.write(f"{param[-1]}\n")

    start, end = nameTab[macro]

    for i in range(start+1, end):
        defline = defTab[i].copy()

        if (flag is not None):
            defline.insert(0, flag)
            flag = None

        if len(defline) > 1:
            action = defline[-1]
            i = 1
            for p in param:
                action = action.replace("?"+str(i), p)
                defline[-1] = action
                i += 1

        expandedMacros.append(defline)

    f.write("\n")
    f.close()
    end_index = nameTab[macro][1]
    return end_index


def pass2():

    open('argtab.txt', "w").close()
    i = 0
    flag = 0
    for i in range(len(program)):
        if program[i][0] == 'MEND':
            flag = 0
            continue

        if flag == 1:
            continue

        line = program[i].copy()
        # print(line)

        if (len(line) > 1 and line[1] == 'MACRO'):
            flag = 1
            continue

        elif line[0] == 'MEND':
            flag = 0
            continue

        elif line[0] in nameTab.keys() or line[1] in nameTab.keys():
            expandMacro(line)

        else:
            expandedMacros.append(line)


def writeToFile():
    f = open("nameTab.txt", "w")
    f.write("Macro\t\tStart\tEnd\n")
    for i in nameTab.keys():
        f.write(f"{i}\t\t\t{nameTab[i][0]}\t\t{nameTab[i][1]}\n")
    f.close()

    f = open("defTab.txt", "w")
    index = 0
    for line in defTab:
        f.write(str(index) + ".\t   " + "\t".join(line) + "\n")
        index += 1
    f.close()

    f = open("expandedMacros.txt", "w")
    for line in expandedMacros:
        f.write("\t".join(line)+"\n")
    f.close()


# main
readFile()
readMacros()
pass2()
writeToFile()
