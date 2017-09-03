class triNode(object):
    
    def __init__(self):
        self.children = {}
        self.eow = False

class tri(object):
    
    def __init__(self):
        self.root = triNode()
    
    def insert(self,Node,string,index):
        if len(string)==index:
            Node.eow = True
            return
        if string[index] in Node.children:
            self.insert(Node.children[string[index]],string,index+1)
        else:
            Node.children[string[index]] = triNode()
            self.insert(Node.children[string[index]],string,index+1)
            
    def search(self,Node,string,index):
        if len(string)==index:
            #print "here"
            if Node.eow == True:
                #print "yo"
                return 1
            else:
                return 0
        elif string[index] in Node.children:
            #print "string char",string[index],index
            return self.search(Node.children[string[index]],string,index+1)
        else:
            return 0
        
    def startswith(self,Node,string,index):
        if len(string) == index:
            return True
        elif string[index] in Node.children:
            #print Node.children[string[index]].children
            #print "string char",string[index],index
            return self.startswith(Node.children[string[index]],string,index+1)
        else:
            return False
        
            
        


class Solution(object):
    def dfs(self,board,string,row,col,t,visited,sol):
        
        if (row < 0 or row >= len(board) or col < 0 or col >= len(board[0])):
            return
        if (visited[row][col]):
            return
        
        string +=board[row][col]
        
        if(not t.startswith(t.root,string,0)):
            
            return
        if(t.search(t.root,string,0)):
            
            sol.add(string)
            
        visited[row][col] = True
        
        self.dfs(board,string,row+1,col,t,visited,sol)
        self.dfs(board,string,row-1,col,t,visited,sol)
        self.dfs(board,string,row,col+1,t,visited,sol)
        self.dfs(board,string,row,col-1,t,visited,sol)
        
        visited[row][col] = False
        
        
        
        
        
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        
        """
        t = tri()
        for word in words:
            t.insert(t.root,word,0)
            #print (t.startswith(t.root,"ab",0))
        
        sol = set()
        visited =[[False for i in range(len(board[0]))] for i in range(len(board))]
        for i in xrange(len(board)):
            for j in xrange(len(board[i])):
                self.dfs(board,"",i,j,t,visited,sol)
        
        return list(sol)
      