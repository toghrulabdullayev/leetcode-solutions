from typing import List


def alienOrder(words: List[str]) -> str:
    adj = {c: set() for w in words for c in w}

    for i in range(len(words) - 1):
        w1, w2 = words[i], words[i + 1]
        minLen = min(len(w1), len(w2))
        if len(w1) > len(w2) and w1[:minLen] == w2[:minLen]:
            return ""
        for j in range(minLen):
            if w1[j] != w2[j]:
                # char in w1 will be a key to the value of chars set from w2 coming after w1 in "alien" alphabet
                adj[w1[j]].add(w2[j])  # char in w2 comes AFTER the char in w1
                break

    visit = {}  # False=visited, True=current path
    res = []

    # post-order DFS
    def dfs(c):
        if c in visit:
            return visit[c]

        visit[c] = True
        for nei in adj[c]:
            if dfs(nei):
                return True  # detected a loop (invalid)
        visit[c] = False
        res.append(c)

    for c in adj:
        if dfs(c):
            return ""
    res.reverse()
    return "".join(res)


print(alienOrder(["wrt", "wrf", "er", "ett", "rftt"]))
