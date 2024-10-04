import sys

input = sys.stdin.readline


class Node(object):
    def __init__(self, key, data=None):
        self.key = key
        self.data = data
        self.children = dict()


class Trie(object):
    def __init__(self):
        self.head = Node(None)

    def insert(self, string):
        current_node = self.head

        for char in string:  # 문자열의 문자 하나하나를 node로 집어 넣는다
            if char not in current_node.children:
                current_node.children[char] = Node(char)
            current_node = current_node.children[char]

        current_node.data = string  # 문자열이 다 넣어졌다면, 마지막 노드의 data에 문자열을 넣어준다


def find(trie, string):
    check = 0
    for node in trie.children.values():
        if node.key == string[0]:
            string.pop(0)
            if len(string) != 0:
                find(node, string)
                if len(string) == 0:
                    return True
            else:
                return True
    return False



def insert_find():
    N, M = map(int, input().split())
    trie = Trie()
    answer = 0
    for _ in range(N):  # 문자들 node에 넣기
        string = input().rstrip()
        trie.insert(string)

    for _ in range(M):
        string = input().rstrip()
        if find(trie.head, list(string)):
            answer += 1

    print(answer)


insert_find()
