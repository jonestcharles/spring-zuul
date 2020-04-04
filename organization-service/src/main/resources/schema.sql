DROP TABLE IF EXISTS organizations;

CREATE TABLE organizations (
  organization_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  name                   TEXT NOT NULL,
  contact_name           TEXT NOT NULL,
  contact_email          TEXT NOT NULL,
  contact_phone          TEXT   NOT NULL);

INSERT INTO organizations (organization_id, name, contact_name, contact_email, contact_phone)
VALUES ('7be28a0f-22e5-4ccf-a3b8-dc6a106a0dca', 'Oracle', 'Todd Johnson', 'todd.johnson@orcle.com', '763-545-8756');

INSERT INTO organizations (organization_id, name, contact_name, contact_email, contact_phone)
VALUES ('9d21c585-c395-4865-8951-cd30381fdf80', 'Apex', 'Ted Douglas','ted.douglas@apx.com', '651-834-9087');
