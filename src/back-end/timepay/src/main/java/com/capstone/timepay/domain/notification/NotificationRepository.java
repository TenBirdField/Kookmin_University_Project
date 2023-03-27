package com.capstone.timepay.domain.notification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {

    Page<Notification> findByTitleContaining(String title, Pageable pageable);

    Page<Notification> findAll(Pageable pageable);
}
