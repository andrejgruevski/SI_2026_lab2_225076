Andrej Gruevski 225076

<h1>Втора лабораториска вежба по Софтверско инженерство</h1>

<h3>Control Flow Graph</h3>

<h4>searchBookByTitle</h4>

<img width="550" height="550" alt="CFG-searchBook" src="https://github.com/user-attachments/assets/27d08379-7569-4a8c-bb69-a5361b778669" />

<h4>borrowBook</h4>

<img width="550" height="550" alt="CFG-borrowBook" src="https://github.com/user-attachments/assets/23b58c42-a037-4363-97e5-8a800a6b1bec" />

<h3>Цикломатска комплексност</h3>

<p>
Цикломатската комплексност за searchBookByTitle е 5, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајов P=4, па цикломатската комплексност изнесува 5.
</p>

<p>
Цикломатската комплексност за borrowBook е 5, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајов P=4, па цикломатската комплексност изнесува 5.
</p>

<h3>Тест случаи според критериумот Every Statement</h3>

| Statement / Линија код | Test 1 | Test 2 | Test 3 |
|---|---|---|---|
| if(title.isEmpty()) | * | * | * |
| throw IllegalArgumentException | * |  |  |
| List<Book> results = new ArrayList<Book>() |  | * | * |
| for(Book book : books) |  | * | * |
| if(book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) |  | * | * |
| results.add(book) |  | * |  |
| if(results.isEmpty()) |  |  | * |
| return null |  |  | * |
| return results |  | * |  |

<p>
Минимален број на тест случаи за функцијата според Every Statement критериумот е 3.
</p>

<p>
Test 1: Празен title - exception path.
</p>

<p>
Test 2: Постои книга - враќа листа со книги.
</p>

<p>
Test 3: Нема пронајдени книги - враќа null.
</p>

<h3>Тест случаи според критериумот Every Branch</h3>

| Branch / Гранка | Test 1 | Test 2 | Test 3 | Test 4 |
|---|---|---|---|---|
| if(title.isEmpty() \|\| author.isEmpty()) → TRUE | * |  |  |  |
| if(title.isEmpty() \|\| author.isEmpty()) → FALSE |  | * | * | * |
| if(title match && author match) → TRUE |  | * | * |  |
| if(title match && author match) → FALSE |  |  |  | * |
| if(!book.isBorrowed()) → TRUE |  | * |  |  |
| if(!book.isBorrowed()) → FALSE |  |  | * |  |
| throw IllegalArgumentException | * |  |  |  |
| book.setBorrowed(true) |  | * |  |  |
| throw RuntimeException("Book is already borrowed.") |  |  | * |  |
| throw RuntimeException("Book not found") |  |  |  | * |
| return |  | * |  |  |

<p>
Минимален број на тест случаи за исполнување на Every Branch критериумот за функцијата borrowBook е 4.
</p>

<p>
Test 1: Празен title и author - се покрива exception path за невалиден внес.
</p>

<p>
Test 2: Успешно позајмување книга - се покрива гранката каде книгата е пронајдена и не е позајмена.
</p>

<p>
Test 3: Обид за позајмување веќе позајмена книга - се покрива гранката каде книгата е веќе borrowed.
</p>

<p>
Test 4: Книга не постои - се покрива гранката каде не е пронајдена книга.
</p>

<h3>Тест случаи според критериумот Multiple Condition</h3>

<h4>borrowBook - if(title.isEmpty() || author.isEmpty())</h4>

<p>
A = title.isEmpty()<br>
B = author.isEmpty()
</p>

| Test Case | A | B | Result |
|---|---|---|---|
| Test 1 | T | T | T |
| Test 2 | T | F | T |
| Test 3 | F | T | T |
| Test 4 | F | F | F |

<p>
Минимален број на тест случаи за Multiple Condition критериумот кај borrowBook е 4, бидејќи постојат 4 комбинации на подусловите.
</p>

<br>

<h4>searchBookByTitle - if(book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())</h4>

<p>
A = book.getTitle().equalsIgnoreCase(title)<br>
B = !book.isBorrowed()
</p>

| Test Case | A | B | Result |
|---|---|---|---|
| Test 1 | T | T | T |
| Test 2 | T | F | F |
| Test 3 | F | T | F |
| Test 4 | F | F | F |

<p>
Минимален број на тест случаи за Multiple Condition критериумот кај searchBookByTitle е 4, бидејќи постојат 4 комбинации на подусловите.
</p>

<p>
Test 1: Двата подуслови се true.
</p>

<p>
Test 2: Првиот подуслов е true, вториот false.
</p>

<p>
Test 3: Првиот подуслов е false, вториот true.
</p>

<p>
Test 4: Двата подуслови се false.
</p>
