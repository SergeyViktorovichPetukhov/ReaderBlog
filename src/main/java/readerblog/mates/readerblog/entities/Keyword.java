package readerblog.mates.readerblog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author viiri@mail.ru
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "key_words")
@EqualsAndHashCode(exclude = "books")
public class Keyword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "word")
	private String keyword;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "key_words_books",
			joinColumns = @JoinColumn(name = "key_words_id"),
			inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> books;
}
