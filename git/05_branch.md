# Branch 기초 명령어

* 브랜치 생성

  ```bash
  $ git branch {브랜치이름}
  ```

* 브랜치 목록

  ```bash
  $ git branch
  * master
    test
  ```

* 브랜치 이동

  ```bash
  $ git checkout test
  Switched to branch 'test'
  (test) $
  ```

* 브랜치 생성 및 이동

  ```bash
  $ git checkout -b test2
  Switched to a new branch 'test2'
  (test2) $
  ```

* 브랜치 병합

  ```bash
  $ git merge test2
  Updating cf28034..3888136
  Fast-forward
   test2.txt | 0
   1 file changed, 0 insertions(+), 0 deletions(-)
   create mode 100644 test2.txt
  ```

* 브랜치 삭제

  ```bash
  $ git branch -d test2
  Deleted branch test2 (was 3888136).
  ```

  

