#二叉排序树的删除节点
##第一种情况 删除叶子节点
1.需要先找到要删除的节点targetNode

2.找到targetNode的父节点parent

3.确定targetNode是parent的左子节点还是右子节点

4.根据前面的情况来对应删除

左子节点：parent.left = null
右子节点：parent.right = null

##第二种情况 删除只有一个子树的结点
1.需要先找到要删除的节点targetNode

2.找到targetNode的父节点parent

3.确定targetNode的子节点是左子节点还是右子节点

4.targetNode是parent的左子节点还是右子节点

5.如果targetNode有左子节点
(1)如果targetNode是parent的左子节点
parent.left=targetNode.left
(2)如果targetNode是parent的右子节点
parent.right=targetNode.left

6.如果targetNode有右子节点
(1)如果targetNode是parent的左子节点
parent.left=targetNode.right
(2)如果targetNode是parent的右子节点
parent.right=targetNode.right

##第三种情况 删除有两棵子树的结点
1.需要先找到要删除的节点targetNode

2.找到targetNode的父节点parent

3.从targetNode的右子树找到最小的节点

4.用一个临时变量，将最小节点的值保存temp

5.删除该最小节点

6.targetNode.value=temp
