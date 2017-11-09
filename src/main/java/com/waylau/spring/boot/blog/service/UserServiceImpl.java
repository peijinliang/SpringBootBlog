package com.waylau.spring.boot.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.waylau.spring.boot.blog.domain.User;
import com.waylau.spring.boot.blog.repository.UserRepository;

/**
 * 用户服务接口实现.
 *
 * @since 1.0.0 2017年5月29日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#saveOrUpateUser(com.waylau.spring.boot.blog.domain.User)
	 */
	@Transactional
	@Override
	public User saveOrUpateUser(User user) {
		return userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#registerUser(com.waylau.spring.boot.blog.domain.User)
	 */
	@Transactional
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#removeUser(java.lang.Long)
	 */
	@Transactional
	@Override
	public void removeUser(Long id) {
		userRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#getUserById(java.lang.Long)
	 */
	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.waylau.spring.boot.blog.service.UserService#listUsersByNameLike(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        // 模糊查询
        name = "%" + name + "%";
        Page<User> users = userRepository.findByNameLike(name, pageable);
        return users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

}
