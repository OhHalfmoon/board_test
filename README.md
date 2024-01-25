   
# 📌프로젝트명

> project : Spring 기반 게시판  
> 주제 : 페이징 및 검색기능이 활용가능한 Spring기반 게시판 


<br/>

## 🛠개발 환경 설정🛠

> Front-end
- JQuery & AjAX, BootStrap3

> Back-end
- JAVA 1.8, Spring framework5, Framework Mybatis, Spring-Security, OracleDB
  
> Tools
- STS, OracleSqlDeveloper, Git

<br/>
<br/>

## ❔선정계기
- 검색기능과 페이징처리기능(Rownum, Criteria)을 파라미터로 Controller에서 처리하는 과정을  
게시판 구현을 통해 학습하고자 합니다.
 

## 🙋구현내용

### <a href="https://jonas-portfolio.notion.site/jonas-portfolio/Spring-b4fa0f4c62d4452f903774341eeedccc">Notion Link</a> <br>
- 게시판 : 게시글 C.R.U.D 및 파일첨부
- 댓글 : 댓글 C.R.U.D
- 검색 : 필터링검색(작성자, 제목, 내용), 페이징처리
- Security : 로그인/로그아웃, 게시물/댓글 작성 및 조회시 계정확인



### 📑세부내용  
      
1. 로그인/로그아웃
- 비로그인시, 상단바 드롭다운을 통해 또는 게시글 작성 버튼을 통해 로그인이 가능합니다.
- 로그인 상태시, 상단바 드롭다운을 통해 로그아웃 화면으로 이동합니다.
- 회원의 비밀번호는 BcryptPasswordEncoder를 통해 인코딩된 상태로 DB에 저장하였습니다.  
![비밀번호 BcryptPasswordEncoder](https://github.com/OhHalfmoon/board_test/assets/132035690/18e84aa5-72ad-4755-9504-4fde021b80b5)  

<br/>    

2. 게시판(Board) :
- 글 작성시, 현재 로그인한 회원의 ID값이 작성자가 됩니다.
- Security가 적용되어현재 게시글의 작성자와 현재 로그인한 회원 정보를 비교후 수정/삭제 기능이 활성화됩니다.  
![security1](https://github.com/OhHalfmoon/board_test/assets/132035690/ac9bac5e-d218-49e6-a6a4-1fe7aee1354a)
<br/>

- Controller에서 @PreAuthorize를 통해 작성자를 검사하여 수정/삭제가 이루어지도록 설정했습니다.  
![security3](https://github.com/OhHalfmoon/board_test/assets/132035690/e4737372-5795-4e52-b0b8-971b95639ce3)  
<br/>  


- URL을 통한 접근을 방지하고자 form-POST 태그내에 CSRF토큰을 추가했습니다.
![security2](https://github.com/OhHalfmoon/board_test/assets/132035690/487105a1-d09c-4083-914b-9fa8ac38049d)  
<br/>  

- 첨부파일은 uuid를 활용하여 중복을 방지하였습니다.
- 이미지파일 여부를 체크하여, 이미지파일은 썸네일 이미지를 제공합니다.
- 이미지파일이 아닌 첨부파일은 아이콘이미지로 대체하여 파일첨부를 확인할 수 있습니다.
- 게시글 삭제시, 첨부파일과 댓글여부를 확인합니다.  
if문으로 해당글의 bno를 받는 첨부파일과 댓글여부를 확인후, 있을경우 우선 삭제합니다.  
썸네일, 첨부파일, 댓글이 삭제된 후 게시글이 삭제됩니다.
<br/>
<br/>



 3. 댓글(Reply) :    
- 댓글 또한 Board와 마찬가지로 security가 적용되어있습니다.
- 글작성과 같이 작성, 수정, 삭제의 과정에서 rno 뿐 아니라 작성자의 정보까지 대조합니다.  
![secre1](https://github.com/OhHalfmoon/board_test/assets/132035690/94d9a706-3db0-4832-9fd9-408eea1f1906)  
<br/>  

![secre2](https://github.com/OhHalfmoon/board_test/assets/132035690/d2fe1107-05b9-4a6a-a769-08e8b572aca9)  
<br/>  

![secre3](https://github.com/OhHalfmoon/board_test/assets/132035690/50365f60-953d-44ae-92f8-96832e365aba)
<br/>
<br/>

4. 페이징 및 검색 : 
- Mybatis에서 페이징은 SQL의 rownum을 통해 한 화면에 나오는 결과물의 수를 조절하였습니다.  
![page3](https://github.com/OhHalfmoon/board_test/assets/132035690/c0d3a449-3084-480a-a5db-c0fa42abcc3f)
  
<br/>  

- Spring에서는 Criteria클래스와 PageDTO에서 PageNum, Amount, Type, Keyword값을 Controller의 파라미터로 전달합니다.
![Criteria](https://github.com/OhHalfmoon/board_test/assets/132035690/69f3b1f0-36f9-4970-9417-839e43ff7e36)  
<br/>   

![controller](https://github.com/OhHalfmoon/board_test/assets/132035690/ff4c7fb2-8600-4d98-ae2d-35c47e3ba343)  
<br/>  
  
- 검색은 제목”T”/내용”C”/작성자”W”를 활용하여 6가지의 경우의 수로 검색 구현했습니다.
![search1](https://github.com/OhHalfmoon/board_test/assets/132035690/99c20ef6-0bbb-4c43-add0-36fcffac5895)
![search2](https://github.com/OhHalfmoon/board_test/assets/132035690/3dd57179-c957-40a1-8f3f-14d10d3c5b19)
<br/>   
  
- 검색시 검색종류와 키워드를 필수로 입력받도록 설정했습니다.  
![search4](https://github.com/OhHalfmoon/board_test/assets/132035690/8c362f70-3da3-4183-a0c3-a3c9055fb2b5)
- Mybatis의 <sql> 태그를 이용해서 SQL을 별도로 보관하고, include시키는 형태로 구현했습니다.  
![search6](https://github.com/OhHalfmoon/board_test/assets/132035690/cc44761c-4e97-458c-a943-d4dbdcf1abc5)
<br/>
<br/>
  


  
