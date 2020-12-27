## Git命令

### git branch

1. git branch <branch-name> 创建分支但不切换
2. git checkout -b <branch-name>  创建分支并且切换
3. git branch <branch-name> commit_id 指定commit_id创建分支
4. git checkout -b <branch-name> commit_id 
5. git checkout -b totallyNotMaster o/master， 跟踪远程分支

### 合并分支

#### git merge

1. git merge bugFix， 切换当前分支，merge别人的改动，**merge完会多一个节点**

#### git rebase

第二种合并分支的方法是 `git rebase`。Rebase 实际上就是取出一系列的提交记录，“复制”它们，然后在另外一个地方逐个的放下去。

1. git rebase target_branch, 把当前分支修改复制到目标分支
2. 切换到bugFix分支，执行git rebase master, 把**bugFix的改动记录**和b**ugFix分支的指针**复制到master分支
3. 切换到master分支，执行git rebase bugFix
4. git rebase bugFix master=>git checkout master, git rebase bugFix， 将master分支上的差异都合并到bugFix分支

 ### HEAD

#### 分离HEAD

1. 分离的 HEAD 就是让其指向了某个具体的提交记录而不是分支名。在命令执行之前的状态如下所示：HEAD -> master -> C1, HEAD 指向 master， master 指向 C1
2. git checkout C1, 使得HEAD**直接**指向C1
3. git checkout 可以是分支名，也可以是某个提交hash
4. **git checkout commit_id or <branch-name>，是的HEAD指向commit_id， 或分支名**

#### 相对引用

- 使用 `^` 向上移动 1 个提交记录
- 使用 `~<num>` 向上移动多个提交记录，如 `~3`， 不跟数字时与 `^` 相同，向上移动一次

1. git checkout master^，修改master上HEAD指向master的上一个提交
2. git checkout HEAD~4, 将HEAD指针后退4步，**不包括自己的4步**

### 提交记录移动（HEAD移动）

1. git checkout master^, HEAD指向当前的上一个提交
2. git checkout HEAD^向上移动

#### 强制修改分支位置（分支名移动）

1. git branch -f master HEAD~3， 将 master 分支强制指向 HEAD 的第 3 级父提交
2. 也可以指定某个hash, git branch -f master commit_hash

### 撤销变更

有两种： git reset,  git revert

1. git reset HEAD~1， 撤销本地提交，就像本地从没有提交过，不能在分离HEAD里重置
2. git revert HEAD， 远端会多一个revert的提交记录

### 自由修改提交树

- `git cherry-pick <提交号>...`, 如果你想将一些提交复制到当前所在的位置（`HEAD`）下面的话， Cherry-pick 是最直接的方式了。

1. git cherry-pick c1 c2 c3... 当你知道你所需要的提交记录（**并且**还知道这些提交记录的哈希值）时, 用 cherry-pick 再好不过了 —— 没有比这更简单的方式了。

2. git rebase -i HEAD-5 包含当前提交往上加上4个提交记录，交互式rebase

### 技巧

1. 修改以前的提交

- 先用 `git rebase -i` 将提交重新排序，然后把我们想要修改的提交记录挪到最前
- 然后用 `git commit --amend` 来进行一些小修改
- 接着再用 `git rebase -i` 来将他们调回原来的顺序
- 最后我们把 master 移到修改的最前端（用你自己喜欢的方法），就大功告成啦！

2. 修改以前的提交方法2

- 先用 `git checkout master` 
- ``git cherry-pick amend-commit-hashid``
-  `git commit --amend` 来进行一些小修改
- ``git cherry-pick next-commit-hashid``

### git tag

git tag v1 c1

如果不指定提交记录c1，Git会用HEAD所指向的位置

### git describe

`git describe` 的语法是：

```
git describe <ref>
```

`<ref>` 可以是任何能被 Git 识别成提交记录的引用，如果你没有指定的话，Git 会以你目前所检出的位置（`HEAD`）。

它输出的结果是这样的：

```
<tag>_<numCommits>_g<hash>
```

`tag` 表示的是离 `ref` 最近的标签， `numCommits` 是表示这个 `ref` 与 `tag` 相差有多少个提交记录， `hash` 表示的是你所给定的 `ref` 所表示的提交记录哈希值的前几位。

### 两个父节点

git checkout master^, checkout到第一个提交的父节点

git checkout master^2, checkout到第二个提交的父节点

### 远程仓库

- `<remote name>/<branch name>`远程分支有一个命名规范 —— 它们的格式
- 如果你看到一个名为 `o/master` 的分支，那么这个分支就叫 `master`，远程仓库的名称就是 `o`

> 大多数的开发人员会将它们主要的远程仓库命名为 `origin`，并不是 `o`。这是因为当你用 `git clone` 某个仓库时，Git 已经帮你把远程仓库的名称设置为 `origin` 了

#### git fetch

`git fetch` 完成了仅有的但是很重要的两步:

- 从远程仓库下载本地仓库中缺失的提交记录
- 更新远程分支指针(如 `o/master`)

`git fetch` 并不会改变你本地仓库的状态.它不会更新你的 `master` 分支，也不会修改你磁盘上的文件。

![image-20201227174932657](F:\note\Git命令.assets\image-20201227174932657.png)

#### git pull

其实有很多方法的 —— 当远程分支中有新的提交时，你可以像合并本地分支那样来合并远程分支。也就是说就是你可以执行以下命令:

- `git cherry-pick o/master`
- `git rebase o/master`
- `git merge o/master`

**相当于git fetch和git merge的缩写**

### git push

1. push 前

<img src="F:\note\Git命令.assets\image-20201227180802804.png" alt="image-20201227180802804" style="zoom:80%;" />

2. push 后

<img src="F:\note\Git命令.assets\image-20201227180740153.png" alt="image-20201227180740153" style="zoom:80%;" />

### git rebase

如果当前开发基于远端旧版本开发的，开发完毕后，远端又有新的变更

1. git fetch; git rebase o/master; git push

<img src="F:\note\Git命令.assets\image-20201227181328618.png" alt="image-20201227181328618" style="zoom:80%;" />

2. git fetch; git merge o/master; git push

   <img src="F:\note\Git命令.assets\image-20201227181752373.png" alt="image-20201227181752373" style="zoom:80%;" />

<img src="F:\note\Git命令.assets\image-20201227181722325.png" alt="image-20201227181722325" style="zoom:80%;" />

3. git pull --rebase

   git pull --rebase; git push; 相当于第一个命令的简写

### 按顺序提交

1. git fetch
2. git rebase o/master side1
3. git rebase side1 side2
4. git rebase side2 side3
5. git rebase side3 master

#### 跟踪远程分支

1. git checkout -b totallyNotMaster o/master
2. git branch -u o/master foo， 这样 `foo` 就会跟踪 `o/master` 了。如果当前就在 foo 分支上, 还可以省略 foo：git branch -u o/master

#### git push参数

git push <remote> <place>

git push origin master

> *切到本地仓库中的“master”分支，获取所有的提交，再到远程仓库“origin”中找到“master”分支，将远程仓库中没有的提交记录都添加上去，搞定之后告诉我。*
>
> 我们通过“place”参数来告诉 Git 提交记录来自于 master, 要推送到远程仓库中的 master。它实际就是要同步的两个仓库的位置。

要同时为源和目的地指定 `<place>` 的话，只需要用冒号 `:` 将二者连起来就可以了：

```
git push origin <source>:<destination>
```

#### git fetch参数

git fetch origin foo

git push origin <source>:<destination>， `source` 现在指的是远程仓库中的位置，而 `<destination>` 才是要放置提交的本地仓库的位置。它与 git push 刚好相反，这是可以讲的通的，因为我们在往相反的方向传送数据。

### git push

- `git push origin :side`<source>为空则删除远端对应的分支

#### git pull参数

`git pull origin foo` 相当于：

```
git fetch origin foo; git merge o/foo
```

`git pull origin bar~1:bugFix` 相当于：

```
git fetch origin bar~1:bugFix; git merge bugFix
```

 git pull 实际上就是 fetch + merge 的缩写