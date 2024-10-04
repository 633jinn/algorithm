import sys

input = sys.stdin.readline

N = int(input())
'''
자료 구조
문자열
트리
트라이 : 문자열 탐색에 특화되어 있는 "트리
'''


class Node(object):
    def __init__(self, key, data=None):
        self.key = key
        self.data = data  # 트리 height로 이용
        self.children = {}


class Trie(object):
    def __init__(self):
        self.head = Node(None)  # 시작 노드는 값이 없게끔(data = None) 설정

    def insert(self, lst):
        current = self.head
        step = 1
        for i in lst:
            if i not in current.children:  # 현재 노드의 children 필드에 i값이 없다면
                current.children[i] = Node(i, step)  # i 값으로 노드를 만들어 딕셔너리에 추가
                current.children = dict(
                    sorted(current.children.items()))  # 오름차순 정렬, sorted사용시 리스트로 바뀌기 때문에 다시 dict로 변경해줌
            current = current.children[i]  # 현재 노드를 i노드로 변경
            step += 1


def add_fruit():
    trie = Trie()
    for i in range(N):
        lst = list(map(str, input().split()))
        step = lst.pop(0)

        trie.insert(lst)  # 노드에 값을 넣어줌

    print_fruit(trie.head, "--")


def print_fruit(trie, string):
    for node in trie.children.values():
        print(string * (node.data - 1), node.key, sep="")
        print_fruit(node, string)


add_fruit()
