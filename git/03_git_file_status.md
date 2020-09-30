# git status

```bash
On branch master
# 2) 
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    1.txt
        modified:   README.md
# 1) untracked
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        new.txt

no changes added to commit (use "git add" and/or "git commit -a")

```

* working directory
  * untracked - 깃이 관리하지 않고 있는 파일
    * 파일 생성(new file) 등
  * tracked - 이전 커밋에 포함된 적 있는 파일
    * modified - modified / deleted
    * unmodified - 수정 X (status에 안 뜸)

