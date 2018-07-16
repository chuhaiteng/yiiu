INSERT INTO yiiu_admin_user
  (in_time, password, token, username, role_id)
VALUES
  (to_date('2018-07-16 13:40:24','yyyy-MM-dd HH24:mi:ss'),
   '$2a$10$173kismq9rW55yKEM5rLyej6mfBMr6jYxnFKqSdUFLvV4P9hAHhM.',
   '1efbaf4e-5cba-487f-a8db-dc375073b050',
   'admin',
   1);
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('主页', '0', '/admin/index', 'index');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('话题', '0', '/admin/topic/*', 'topic');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('话题删除', '2', '/admin/topic/delete', 'topic:delete');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('话题列表', '2', '/admin/topic/list', 'topic:list');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('评论', '0', '/admin/comment/*', 'comment');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('评论编辑', '5', '/admin/comment/edit', 'comment:edit');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('评论删除', '5', '/admin/comment/delete', 'comment:delete');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('评论列表', '5', '/admin/comment/list', 'comment:list');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('权限', '0', '/admin/security', 'security');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('后台用户列表', '9', '/admin/admin_user/list', 'admin_user:list');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('角色列表', '9', '/admin/role/list', 'role:list');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('权限列表', '9', '/admin/permission/list', 'permission:list');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('后台用户编辑', '9', '/admin/admin_user/edit', 'admin_user:edit');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('后台用户删除', '9', '/admin/admin_user/delete', 'admin_user:delete');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('角色编辑', '9', '/admin/role/edit', 'role:edit');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('角色删除', '9', '/admin/role/delete', 'role:delete');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('权限编辑', '9', '/admin/permission/edit', 'permission:edit');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('权限删除', '9', '/admin/permission/delete', 'permission:delete');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('用户', '0', '/admin/user/*', 'user');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('用户列表', '19', '/admin/user/list', 'user:list');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('用户禁用', '19', '/admin/user/block', 'user:block');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('删除用户', '19', '/admin/user/delete', 'user:delete');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('日志', '0', '/admin/log/*', 'log');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('日志列表', '27', '/admin/log/list', 'log:list');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('仪表盘', '1', '/admin/index', 'dashboard');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('话题加精', '2', '/admin/topic/good', 'topic:good');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('话题置顶', '2', '/admin/topic/top', 'topic:top');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('权限添加', '9', '/admin/permission/add', 'permission:add');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('话题编辑', '2', '/admin/topic/edit', 'topic:edit');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('后台用户', '0', '/admin/admin_user/*', 'adminUser');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('编辑', '35', '/admin/admin_user/edit', 'admin_user:edit');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('删除', '35', '/admin/admin_user/delete', 'admin_user:delete');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('添加', '35', '/admin/admin_user/add', 'admin_user:add');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('清除Redis缓存', '1', '/admin/clear', 'admin_index:clear');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('索引话题', '1', '/admin/indexedTopic', 'admin_index:indexedTopic');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('标签', '0', '/admin/tag/*', 'tag');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('列表', '43', '/admin/tag/list', 'tag:list');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('编辑', '43', '/admin/tag/edit', 'tag:edit');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('删除', '43', '/admin/tag/delete', 'tag:delete');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('索引标签', '1', '/admin/indexedTag', 'admin_index:indexedTag');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('编辑', '19', '/admin/user/edit', 'user:edit');
INSERT INTO yiiu_permission
  (name, pid, url, value)
VALUES
  ('话题新增', '2', '/admin/topic/create', 'topic:create');

INSERT INTO `yiiu_role` (`id`, `name`)
VALUES
  (1, 'admin'),
  (2, 'manager');


INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('3', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('4', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('6', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('7', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('8', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('20', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('21', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('22', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('28', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('30', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('31', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('32', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('34', '23');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('30', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('40', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('41', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('47', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('3', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('4', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('31', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('32', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('34', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('6', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('7', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('8', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('10', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('11', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('12', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('13', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('14', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('15', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('16', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('17', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('18', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('33', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('20', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('21', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('22', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('48', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('28', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('36', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('37', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('38', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('44', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('45', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('46', '1');
INSERT INTO yiiu_role_permission
  (permission_id, role_id)
VALUES
  ('49', '1');


INSERT INTO yiiu_category
  (in_time, cate_name)
VALUES
  (to_date('2018-07-16 13:40:24','yyyy-MM-dd HH24:mi:ss'), 'OA系统');
INSERT INTO yiiu_category
  (in_time, cate_name)
VALUES
  (to_date('2018-07-16 13:40:24','yyyy-MM-dd HH24:mi:ss'), '卓越系统');