INSERT INTO acl_sid (id, principal, sid)
VALUES (1, 1, 'user1'),
       (2, 1, 'user2');

INSERT INTO acl_class (id, class)
VALUES (1, 'com.demo.springacl.entities.Message');

INSERT INTO message(id, content)
VALUES (1, 'This is a message 1'),
       (2, 'This is a message 2');

INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting)
VALUES (1, 1, 1, NULL, 1, 0),
       (2, 1, 2, NULL, 2, 0);

INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure)
VALUES (1, 1, 1, 1, 1, 1, 1, 1),
       (2, 1, 2, 1, 2, 0, 1, 1),
       (3, 1, 3, 1, 8, 1, 1, 1),
       (4, 2, 1, 1, 1, 1, 1, 1),
       (5, 2, 2, 1, 2, 1, 1, 1),
       (6, 2, 3, 2, 2, 1, 1, 1);