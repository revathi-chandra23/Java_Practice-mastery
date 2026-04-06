package cm.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revathiPractice.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByUserUsername(String username);
}
