

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        bool_arr = [False for i in range(26)]
        currentlen = 0
        maxlen=1
        length=len(s)
        for i in range(0,length):
            cur_letter=s[i]
            if not bool_arr[ord(s[i])-97]:
                bool_arr[ord(s[i]) - 97] = True
                currentlen += 1
                continue
            bool_arr = [False for i in range(26)]
            if maxlen < currentlen:
                maxlen = currentlen
            currentlen = 0
        if maxlen < currentlen:
            maxlen = currentlen
        return maxlen


def main():
    sol=Solution()
    print(sol.lengthOfLongestSubstring("abcabcbb"))

if __name__ == "__main__":
    main()